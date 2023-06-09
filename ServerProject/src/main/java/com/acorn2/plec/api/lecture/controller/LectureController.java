package com.acorn2.plec.api.lecture.controller;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.lecture.Service.LectureService;
import com.acorn2.plec.api.lecture.dto.LectureDto;
import com.acorn2.plec.api.lecture.dto.req.LectureCreateReqDto;
import com.acorn2.plec.api.lecture.dto.req.LectureReadReqDto;
import com.acorn2.plec.api.lecture.dto.req.LectureUpdateReqDto;
import com.acorn2.plec.api.lecture.dto.res.LectureReadListResDto;
import com.acorn2.plec.api.lecture.image.dto.ImageDto;
import com.acorn2.plec.api.lecture.image.dto.ImageNumDto;
import com.acorn2.plec.api.lecture.image.service.ImageService;
import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.common.utils.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;

@Api(value = "Lecture")
@RestController
@RequestMapping("/api/lecture")
public class LectureController {
	@Autowired private LectureService service;
	@Autowired private ImageService imageService;
	@Value("${file.location}")
	private String fileLocation;
	
	
	@ApiOperation(value="강의 목록", notes = "강의 목록을 가져온다.")
	@GetMapping("/lectureList")
	public ComResponseEntity<LectureReadListResDto> getLectureList(@RequestParam String largeCategory,
												@RequestParam(required = false) String smallCategory,
												@Parameter(hidden = true) LectureReadReqDto lectureReadReqDto){
		
		LectureReadListResDto lectureReadListResDto = service.LectureList(lectureReadReqDto);
		
		return new ComResponseEntity<>(new ComResponseDto<>(lectureReadListResDto));
	}
	@ApiOperation(value="강의 하나의 정보", notes = "강의 하나의 정보를 가져온다.") 
	@GetMapping("/lecture-one/{lecNum}")
	public ComResponseEntity<LectureDto> LectureOne(@PathVariable int lecNum){
		
		LectureDto dtoOne = service.LectureOne(lecNum);
		
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
	}
	
	@ApiOperation(value="강의 이미지 업로드", notes = "강의 이미지 업로드")
	@Transactional
	@PostMapping(value="/lecture-img-upload")
	public ComResponseEntity<ImageNumDto> insertImage( @RequestParam("file") MultipartFile file)throws IOException{
		
		return new ComResponseEntity<>(new ComResponseDto<>(imageService.insertImage(file)));
	}
	
	@ApiOperation(value="강의 등록", notes = "강의 등록하기")
	@PostMapping(value="/lecture-insert")
	public ComResponseEntity<Void> lectureInsert(@RequestBody LectureCreateReqDto lectureCreateReqDto) {
		service.LectureInsert(lectureCreateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}
	
	
	
	@ApiOperation(value="강의 이미지 가져오기", notes = "이미지 가져오기 ")
	@GetMapping("/{imageNum}/image")
	public ResponseEntity<byte[]> getImage(int imageNum){
		Map<String, Object> map = imageService.selectImage(imageNum);
		ImageDto imageDto = (ImageDto) map.get("imageDto");
		HttpHeaders headers = (HttpHeaders) map.get("headers");
		
		return new ResponseEntity<byte[]>(imageDto.getData(), headers, HttpStatus.OK);
	}
	
	@ApiOperation(value="강의 수정", notes = "강의 수정하기")
	@PutMapping(value="/{lecNum}/lecture-update")
	public ComResponseEntity<Void> lectureUpdate(@RequestBody LectureUpdateReqDto lectureUpdateReqDto) throws IOException{
		service.LectureUpdate(lectureUpdateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="강의 삭제", notes = "강의 삭제하기")
	@PutMapping("/{lecNum}/lecture-delete")
    public ComResponseEntity<Void> LectureDelete(@RequestParam(value = "lecNum", required = true) int lecNum){
	   
	    service.LectureDelete(lecNum);
	   
	    return new ComResponseEntity<Void>();
   }
		
}