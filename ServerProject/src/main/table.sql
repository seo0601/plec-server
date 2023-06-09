-- 사용자(회원) 정보를 저장할 테이블
CREATE TABLE users(
    LEC_USER_ID VARCHAR2(50) PRIMARY KEY,
    USER_PWD VARCHAR2(100) NOT NULL,
    USER_EMAIL VARCHAR2(100),
    USER_REGDATE DATE,
    USER_PHONE VARCHAR2(32),
    USER_BIRTH DATE,
    MANAGER_YN VARCHAR2(3) DEFAULT 'N',
    profile_num NUMBER,
    USER_LAST_DATE DATE,
    LOGIN_STATUS_CODE VARCHAR2(3) DEFAULT 'N',
    GENERAL_USER_CODE VARCHAR2(3) DEFAULT 'N',
    WITHDREWAL_USER_CODE VARCHAR2(3) DEFAULT 'N',
    REST_USER_CODE VARCHAR2(3) DEFAULT 'N'
);

CREATE TABLE profile_image(
    profile_num Number PRIMARY KEY,
    LEC_USER_ID VARCHAR2(50),
    mimetype varchar(100),
    data BLOB,
    original_name varchar(100),
    regdate DATE,
    update_regdate DATE,
    delete_YN_code VARCHAR2(3) DEFAULT 'Y'
);

CREATE SEQUENCE PROFILE_seq; 


-- QNA_BOARD_QUESTION
CREATE TABLE QNA_BOARD_QUESTION(
    BOARD_QUESTION_NUM NUMBER PRIMARY KEY,
    BOARD_QUESTION_WRITER VARCHAR2(50),
    TITLE VARCHAR2(50),
    VIEWCOUNT NUMBER,
    USER_REGDATE DATE,
    ANSWERED_YN VARCHAR2(3) DEFAULT 'N',
    CONTENT CLOB, 
    UPDATE_DATE DATE,
    DELETE_YN_CODE VARCHAR2(3) DEFAULT 'N'

-- QNA_BOARD_QUESTION 시퀀스
CREATE SEQUENCE QNA_BOARD_QUESTION_seq; 

-- QNA_BOARD_ANSWER
CREATE TABLE QNA_BOARD_ANSWER(
    BOARD_COMMENT_NUM NUMBER,
    BOARD_COMMENT_WRITER VARCHAR2(50),
    BOARD_COMMENT_REF_GROUP NUMBER,
    USER_REGDATE DATE,
    CONTENT CLOB,
    UPDATE_DATE DATE,
    UPDATE_ID VARCHAR2(50),
    DELETE_YN_CODE VARCHAR2(3) DEFAULT 'N'
);
-- QNA_BOARD_ANSWER 시퀀스
CREATE SEQUENCE QNA_BOARD_ANSWER_seq;

-- QNA_USERS_QUESTION
CREATE TABLE QNA_USERS_QUESTION(
    num NUMBER PRIMARY KEY, --글번호
    writer VARCHAR2(50) NOT NULL, --작성자 (로그인된 아이디)
    title VARCHAR2(50) NOT NULL, --제목
    content CLOB, --글 내용
    viewCount NUMBER, -- 조회수
    regdate DATE --글 작성일
);
-- QNA_USERS_QUESTION 시퀀스
CREATE SEQUENCE QNA_USERS_QUESTION_seq; 

-- QNA_USERS_ANSWER
CREATE TABLE QNA_USERS_ANSWER(
    num NUMBER PRIMARY KEY, --댓글의 글번호
    writer VARCHAR2(50), --댓글 작성자의 아이디
    content CLOB, --댓글 내용
    target_id VARCHAR2(100), --댓글의 대상자 아이디
    ref_group NUMBER, -- 게시글 번호
    comment_group NUMBER, -- 답변그룹 번호
    deleted CHAR(3) DEFAULT 'no', -- 삭제여부
    regdate DATE -- 글 작성일
);
-- QNA_USERS_ANSWER 시퀀스
CREATE SEQUENCE QNA_USERS_ANSWER_seq;

-- NOTICE(공지사항)
CREATE TABLE NOTICE(   
    noti_num NUMBER PRIMARY KEY, 
    title VARCHAR2(50) NOT NULL, 
    content CLOB, 
    viewCount NUMBER, 
    regdate DATE, 
    update_regdate DATE,   
    update_id VARCHAR2(50),   
    noti_writer VARCHAR2(50),   
    delete_YN_code VARCHAR2(3) DEFAULT 'N'  

);  
 
-- NOTICE 시퀀스
CREATE SEQUENCE NOTICE_seq;

-- FAQ(자주묻는질문)
CREATE TABLE FAQ(
    FAQ_NUM NUMBER PRIMARY KEY, --자주묻는질문번호
    question CLOB, --질문
    content CLOB, --글 내용
    USER_REGDATE DATE, --사용자 등록일
    UPDATE_DATE DATE, --수정 일
    UPDATE_ID VARCHAR2(50), --수정아이디
    FAQ_WRITER VARCHAR2(50), -- 자주묻는질문 작성자
    DELETE_YN_CODE VARCHAR2(3) DEFAULT 'N'-- 삭제여부코드
);
-- FAQ 시퀀스
CREATE SEQUENCE FAQ_seq;

-- LECTURE 테이블 
CREATE TABLE LECTURE(
    LEC_NUM NUMBER PRIMARY KEY, --글번호
    IMAGE_NUM Number,
    LEC_WRITER VARCHAR2(50) NOT NULL,
    TEACHER VARCHAR2(50) NOT NULL, --선생님
    TITLE VARCHAR2(50) NOT NULL, --제목
    DESCRIBE CLOB, --강의 설명
    VIDEOPATH VARCHAR2(300), --영상 링크
    VIEWCOUNT NUMBER, -- 조회수
    USER_REGDATE DATE, --등록일
    UPDATE_DATE DATE,
    LARGE_CATEGORY VARCHAR2(15), -- 강의 대분류
    SMALL_CATEGORY VARCHAR2(15), -- 강의 소분류
    UPDATE_ID VARCHAR2(50),
    SERVICE_YN_CODE VARCHAR2(3) DEFAULT 'Y'
);
-- LECTURE 시퀀스
CREATE SEQUENCE LECTURE_seq;

-- 강의 후기
CREATE TABLE LECTURE_REVIEW(
    LEC_RE_NUM NUMBER PRIMARY KEY, --댓글의 글번호
    LEC_RE_WRITER VARCHAR2(100), --댓글 작성자의 아이디
    CONTENT VARCHAR2(500), --댓글 내용   
    LEC_RE_STU_REF_GROUP NUMBER,
    DELETE_YN VARCHAR2(3) DEFAULT 'N',
    STAR NUMBER, --별점    
    USER_REGDATE DATE,
    UPDATE_DATE DATE
);

-- 강의 후기의 글번호를 얻어낼 시퀀스
CREATE SEQUENCE LECTURE_REVIEW_seq;

-- 강의 수강생
CREATE TABLE LECTURE_STUDENT(
    LEC_STU_NUM NUMBER PRIMARY KEY,
    LEC_STU_USER_ID VARCHAR2(50),
    LEC_STU_REF_GROUP NUMBER,
    COMPLETE_YN VARCHAR2(3) DEFAULT 'N',
    USER_REGDATE DATE,
    UPDATE_DATE DATE
);

CREATE SEQUENCE LECTURE_STUDENT_seq;

-- 강의 이미지
CREATE TABLE lecture_image(
    IMAGE_NUM Number PRIMARY KEY,
    mimetype varchar(100),
    data BLOB,
    original_name varchar(100),
    regdate DATE,
    update_regdate DATE,
    delete_YN_code VARCHAR2(3) DEFAULT 'Y'
);

-- QNA_FREE_QUESTION
CREATE TABLE QNA_FREE_QUESTION(
    FREE_QUESTION_NUM NUMBER PRIMARY KEY,
    FREE_QUESTION_WRITER VARCHAR2(50),
    TITLE VARCHAR2(50),
    VIEWCOUNT NUMBER,
    USER_REGDATE DATE,
    ANSWERED_YN VARCHAR2(3) DEFAULT 'N',
    CONTENT CLOB, 
    UPDATE_DATE DATE,
    DELETE_YN_CODE VARCHAR2(3) DEFAULT 'N'
);
-- QNA_FREE_QUESTION 시퀀스
CREATE SEQUENCE QNA_FREE_QUESTION_seq; 

-- QNA_FREE_ANSWER
CREATE TABLE QNA_FREE_ANSWER(
    FREE_COMMENT_NUM NUMBER,
    FREE_COMMENT_WRITER VARCHAR2(50),
    TARGET_ID VARCHAR2(50),
    FREE_COMMENT_REF_GROUP NUMBER,
    COMMENT_GROUP NUMBER,
    USER_REGDATE DATE,
    CONTENT CLOB,
    UPDATE_DATE DATE,
    UPDATE_ID VARCHAR2(50),
    DELETE_YN_CODE VARCHAR2(3) DEFAULT 'N'
);
-- QNA_BOARD_ANSWER 시퀀스
CREATE SEQUENCE QNA_FREE_ANSWER_seq;
