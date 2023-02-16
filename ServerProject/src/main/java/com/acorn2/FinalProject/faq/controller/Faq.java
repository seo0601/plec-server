package com.acorn2.FinalProject.faq.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.faq.dto.req.FaqReadReqDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadListResDto;
import com.acorn2.FinalProject.faq.service.FaqService;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api("FaqController")
@RequestMapping("/api/faq")
public class Faq {
	@Autowired private FaqService service;
	
	@GetMapping
	public com.acorn2.FinalProject.common.dto.ComResponseEntity<FaqReadListResDto> getCdList(
			@Parameter(hidden = true) FaqReadReqDto faqReadReqDto) {
		FaqReadListResDto faqReadListResDto = service.selectFaqList(faqReadReqDto);
		return new com.acorn2.FinalProject.common.dto.ComResponseEntity<>(new ComResponseDto<>(faqReadListResDto));
	}
	
//	@ApiOperation(value="자주묻는질문 리스트", notes = "자주묻는질문의 리스트를 출력함.")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "pageNum", value = "페이지 번호", required = true, dataTypeClass = Integer.class ,example="0"),
//		@ApiImplicitParam(name = "question", value = "질문"),
//		@ApiImplicitParam(name = "content", value = "답변")
//	})
//	@GetMapping("/list")
//	public Map<String, Object> list(@RequestParam(value = "pageNum", required = true)int pageNum,
//			@RequestParam(value = "question", required = false)String question,
//			@RequestParam(value = "content", required = false)String content){	
//		return service.list(pageNum, question, content);
//	}
//	
//	@ApiOperation(value="자주묻는질문 등록", notes = "자주묻는질문을 입력 받아 등록한다.")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "question", value = "질문"),
//		@ApiImplicitParam(name = "content", value = "답변")
//	})
//	@PostMapping("/insert")
//	public Map<String, String> insert(@RequestBody FaqRes faqres) {
//		return service.saveContent(faqres);
//	}
//	
//	@ApiOperation(value="자주묻는질문 수정", notes = "자주묻는질문을 입력 받아 등록한다.")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "num", value = "질문번호", required = true, example = "0", dataTypeClass = Integer.class),
//		@ApiImplicitParam(name = "question", value = "질문"),
//		@ApiImplicitParam(name = "content", value = "답변")
//	})
//	@PutMapping("/{num}/update")
//	public Map<String, String> update(@PathVariable int num, @RequestBody FaqRes faqRes){
//		
//		FaqReadReqDto dto = new FaqReadReqDto();
//		dto.setNum(num);
//		dto.setQuestion(faqRes.getQuestion());
//		dto.setContent(faqRes.getContent());
//		
//		return service.updateContent(dto);
//	}
//	
//	@ApiOperation(value="자주묻는질문 업데이트 전 상세", notes = "자주묻는질문의 업데이트 전 그 상세 데이터 내용을 가져온다.")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "num", value = "질문번호", required = true, example = "0" , dataTypeClass = Integer.class)
//	})
//	@GetMapping("/{num}/update")
//	public Map<String, Object> update(@PathVariable int num){
//		
//		return service.getData(num);
//	}
//	
//	@ApiOperation(value="자주묻는질문 삭제", notes = "자주묻는질문의 데이터를 삭제한다.")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "num", value = "질문번호", required = true, example = "0" , dataTypeClass = Integer.class)
//	})
//	@DeleteMapping("/{num}/delete")
//	public Map<String, String> delete(@PathVariable int num){
//		
//		return service.deleteContent(num);
//	}
	
}