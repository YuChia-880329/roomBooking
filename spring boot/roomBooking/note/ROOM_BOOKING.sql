BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE BOOKING_ORDER';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE PAY_METHOD';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE MEMBER';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ROOM_IMG';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ROOM_SHOWER_JOIN';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE SHOWER';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ROOM';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE SCENE';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE NEW_FEATURE';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE HOTEL_FEATURE_JOIN';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE HOTEL';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE HOTEL_ACCOUNT';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE FEATURE';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE SECTION';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/







-- 地區資料表
CREATE TABLE SECTION
(
    CODE VARCHAR2(5) NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    CONSTRAINT SECTION_PK PRIMARY KEY (CODE),
    CONSTRAINT SECTION_UNIQUE1 UNIQUE (NAME)
);

COMMENT ON COLUMN SECTION.CODE IS '地區編碼';
COMMENT ON COLUMN SECTION.NAME IS '地區名稱';

INSERT INTO SECTION (CODE, NAME) VALUES ('KLU', '基隆市');
INSERT INTO SECTION (CODE, NAME) VALUES ('TPH', '新北市');
INSERT INTO SECTION (CODE, NAME) VALUES ('TPE', '臺北市');
INSERT INTO SECTION (CODE, NAME) VALUES ('TYC', '桃園市');
INSERT INTO SECTION (CODE, NAME) VALUES ('HSH', '新竹縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('HSC', '新竹市');
INSERT INTO SECTION (CODE, NAME) VALUES ('MAC', '苗栗市');
INSERT INTO SECTION (CODE, NAME) VALUES ('MAL', '苗栗縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('TXG', '臺中市');
INSERT INTO SECTION (CODE, NAME) VALUES ('CWH', '彰化縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('CWS', '彰化市');
INSERT INTO SECTION (CODE, NAME) VALUES ('NTC', '南投市');
INSERT INTO SECTION (CODE, NAME) VALUES ('NTO', '南投縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('YLH', '雲林縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('CHY', '嘉義縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('CYI', '嘉義市');
INSERT INTO SECTION (CODE, NAME) VALUES ('TNN', '臺南市');
INSERT INTO SECTION (CODE, NAME) VALUES ('KHH', '高雄市');
INSERT INTO SECTION (CODE, NAME) VALUES ('IUH', '屏東縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('PTS', '屏東市');
INSERT INTO SECTION (CODE, NAME) VALUES ('ILN', '宜蘭縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('ILC', '宜蘭市');
INSERT INTO SECTION (CODE, NAME) VALUES ('HWA', '花蓮縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('HWC', '花蓮市');
INSERT INTO SECTION (CODE, NAME) VALUES ('TTC', '臺東市');
INSERT INTO SECTION (CODE, NAME) VALUES ('TTT', '臺東縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('PEH', '澎湖縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('GNI', '綠島');
INSERT INTO SECTION (CODE, NAME) VALUES ('KYD', '蘭嶼');
INSERT INTO SECTION (CODE, NAME) VALUES ('KMN', '金門縣');
INSERT INTO SECTION (CODE, NAME) VALUES ('MZW', '馬祖');
INSERT INTO SECTION (CODE, NAME) VALUES ('LNN', '連江縣');


-- 飯店特色資料表
CREATE TABLE FEATURE
(
    ID NUMBER NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    CONSTRAINT FEATURE_PK PRIMARY KEY (ID),
    CONSTRAINT FEATURE_UNIQUE1 UNIQUE (NAME)
);

COMMENT ON COLUMN FEATURE.ID IS '飯店特色編號';
COMMENT ON COLUMN FEATURE.NAME IS '飯店特色名字';

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE FEATURE_SEQ';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
CREATE SEQUENCE FEATURE_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO FEATURE (ID, NAME) VALUES (FEATURE_SEQ.NEXTVAL, '房內免費Wi-Fi');
INSERT INTO FEATURE (ID, NAME) VALUES (FEATURE_SEQ.NEXTVAL, '停車場');
INSERT INTO FEATURE (ID, NAME) VALUES (FEATURE_SEQ.NEXTVAL, '可寄放行李');



-- 飯店帳號資料表
CREATE TABLE HOTEL_ACCOUNT
(
    ID NUMBER NOT NULL,
    ACCOUNT VARCHAR2(50) NOT NULL,
    PASSWORD VARCHAR2(50) NOT NULL,
    CONSTRAINT HOTEL_ACCOUNT_PK PRIMARY KEY (ID),
    CONSTRAINT HOTEL_ACCOUNT_UNIQUE1 UNIQUE (ACCOUNT)
);

COMMENT ON COLUMN HOTEL_ACCOUNT.ID IS '飯店帳號編號';
COMMENT ON COLUMN HOTEL_ACCOUNT.ACCOUNT IS '飯店帳號';
COMMENT ON COLUMN HOTEL_ACCOUNT.PASSWORD IS '飯店密碼';

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE HOTEL_ACCOUNT_SEQ';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
CREATE SEQUENCE HOTEL_ACCOUNT_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO HOTEL_ACCOUNT (ID, ACCOUNT, PASSWORD) VALUES (HOTEL_ACCOUNT_SEQ.NEXTVAL, 'A123456', '111111');
INSERT INTO HOTEL_ACCOUNT (ID, ACCOUNT, PASSWORD) VALUES (HOTEL_ACCOUNT_SEQ.NEXTVAL, 'B123456', '222222');
INSERT INTO HOTEL_ACCOUNT (ID, ACCOUNT, PASSWORD) VALUES (HOTEL_ACCOUNT_SEQ.NEXTVAL, 'C123456', '333333');
INSERT INTO HOTEL_ACCOUNT (ID, ACCOUNT, PASSWORD) VALUES (HOTEL_ACCOUNT_SEQ.NEXTVAL, 'D123456', '444444');
INSERT INTO HOTEL_ACCOUNT (ID, ACCOUNT, PASSWORD) VALUES (HOTEL_ACCOUNT_SEQ.NEXTVAL, 'E123456', '555555');


-- 飯店資料表
CREATE TABLE HOTEL
(
    ID NUMBER NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    SECTION_CODE VARCHAR2(5) NOT NULL,
    ADDRESS VARCHAR2(150) NOT NULL,
    INTRODUCTION VARCHAR2(300),
    IMG_NAME VARCHAR2(50) NOT NULL,
    ACCOUNT_ID NUMBER NOT NULL,
    CONSTRAINT HOTEL_PK PRIMARY KEY (ID),
    CONSTRAINT HOTEL_UNIQUE1 UNIQUE (ADDRESS),
    CONSTRAINT HOTEL_UNIQUE2 UNIQUE (IMG_NAME),
    CONSTRAINT HOTEL_UNIQUE3 UNIQUE (ACCOUNT_ID),
    CONSTRAINT HOTEL_FK1 FOREIGN KEY (SECTION_CODE) REFERENCES SECTION (CODE),
    CONSTRAINT HOTEL_FK2 FOREIGN KEY (ACCOUNT_ID) REFERENCES HOTEL_ACCOUNT (ID)
);

COMMENT ON COLUMN HOTEL.ID IS '飯店編號';
COMMENT ON COLUMN HOTEL.NAME IS '飯店名稱';
COMMENT ON COLUMN HOTEL.SECTION_CODE IS '飯店區域';
COMMENT ON COLUMN HOTEL.ADDRESS IS '飯店地址';
COMMENT ON COLUMN HOTEL.INTRODUCTION IS '飯店介紹';
COMMENT ON COLUMN HOTEL.IMG_NAME IS '飯店照片名稱';
COMMENT ON COLUMN HOTEL.ACCOUNT_ID IS '飯店帳號編號';

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE HOTEL_SEQ';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
CREATE SEQUENCE HOTEL_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO HOTEL (ID, NAME, SECTION_CODE, ADDRESS, INTRODUCTION, IMG_NAME, ACCOUNT_ID) VALUES (HOTEL_SEQ.NEXTVAL, '忠義飯店', 'TPE', '台北市XX路XX號', '好飯店', 'img1.jpg', 1);
INSERT INTO HOTEL (ID, NAME, SECTION_CODE, ADDRESS, INTRODUCTION, IMG_NAME, ACCOUNT_ID) VALUES (HOTEL_SEQ.NEXTVAL, '中和飯店', 'TPH', '新北市YY路YYY號', '很好飯店', 'img2.jpg', 2);
INSERT INTO HOTEL (ID, NAME, SECTION_CODE, ADDRESS, INTRODUCTION, IMG_NAME, ACCOUNT_ID) VALUES (HOTEL_SEQ.NEXTVAL, '凱薩大酒店', 'HSC', '新竹市ZZZ路ZZ號', '棒飯店', 'img3.jpg', 3);
INSERT INTO HOTEL (ID, NAME, SECTION_CODE, ADDRESS, INTRODUCTION, IMG_NAME, ACCOUNT_ID) VALUES (HOTEL_SEQ.NEXTVAL, '揚名飯店', 'TNN', '台南市G路GGG號', '非常好飯店', 'img4.jpg', 4);
INSERT INTO HOTEL (ID, NAME, SECTION_CODE, ADDRESS, INTRODUCTION, IMG_NAME, ACCOUNT_ID) VALUES (HOTEL_SEQ.NEXTVAL, '吳麗飯店', 'TTC', '台東市UUU路UUUUU號', '極好飯店', 'img5.jpg', 5);


-- 飯店特色聯集資料表
CREATE TABLE HOTEL_FEATURE_JOIN
(
    HOTEL_ID NUMBER NOT NULL,
    FEATURE_ID NUMBER NOT NULL,
    CONSTRAINT HOTEL_FEATURE_JOIN_PK1 PRIMARY KEY (HOTEL_ID, FEATURE_ID),
    CONSTRAINT HOTEL_FEATURE_JOIN_FK1 FOREIGN KEY (HOTEL_ID) REFERENCES HOTEL (ID),
    CONSTRAINT HOTEL_FEATURE_JOIN_FK2 FOREIGN KEY (FEATURE_ID) REFERENCES FEATURE (ID)
);

COMMENT ON COLUMN HOTEL_FEATURE_JOIN.HOTEL_ID IS '飯店編號';
COMMENT ON COLUMN HOTEL_FEATURE_JOIN.FEATURE_ID IS '飯店特色編號';


INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (1, 1);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (1, 2);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (2, 2);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (2, 3);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (3, 1);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (3, 2);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (3, 3);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (4, 1);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (4, 2);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (4, 3);
INSERT INTO HOTEL_FEATURE_JOIN (HOTEL_ID, FEATURE_ID) VALUES (5, 3);



-- 新增特色資料表
CREATE TABLE NEW_FEATURE
(
    ID NUMBER NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
	HOTEL_ID NUMBER NOT NULL,
    CONSTRAINT NEW_FEATURE_PK PRIMARY KEY (ID),
	CONSTRAINT NEW_FEATURE_UNIQUE1 UNIQUE (NAME),
    CONSTRAINT NEW_FEATURE_FK1 FOREIGN KEY (HOTEL_ID) REFERENCES HOTEL (ID)
);

COMMENT ON COLUMN NEW_FEATURE.ID IS '新增特色編號';
COMMENT ON COLUMN NEW_FEATURE.NAME IS '新增特色名字';
COMMENT ON COLUMN NEW_FEATURE.HOTEL_ID IS '所屬飯店';

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE NEW_FEATURE_SEQ';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
CREATE SEQUENCE NEW_FEATURE_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO NEW_FEATURE (ID, NAME, HOTEL_ID) VALUES (NEW_FEATURE_SEQ.NEXTVAL, '鄰近火車站', 1);
INSERT INTO NEW_FEATURE (ID, NAME, HOTEL_ID) VALUES (NEW_FEATURE_SEQ.NEXTVAL, '鄰近美食街', 1);
INSERT INTO NEW_FEATURE (ID, NAME, HOTEL_ID) VALUES (NEW_FEATURE_SEQ.NEXTVAL, '附早餐', 1);



-- 景觀資料表
CREATE TABLE SCENE
(
    ID NUMBER NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    CONSTRAINT SCENE_PK PRIMARY KEY (ID),
    CONSTRAINT SCENE_UNIQUE1 UNIQUE (NAME)
);

COMMENT ON COLUMN SCENE.ID IS '景觀編號';
COMMENT ON COLUMN SCENE.NAME IS '景觀名稱';

INSERT INTO SCENE (ID, NAME) VALUES (1, '市景');
INSERT INTO SCENE (ID, NAME) VALUES (2, '山景');
INSERT INTO SCENE (ID, NAME) VALUES (3, '海景');
INSERT INTO SCENE (ID, NAME) VALUES (4, '無窗');
INSERT INTO SCENE (ID, NAME) VALUES (5, '其他');



-- 房間資料表
CREATE TABLE ROOM
(
    ID NUMBER NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    TOTAL_NUM NUMBER NOT NULL,
    INVALID_NUM NUMBER NOT NULL,
    USED_NUM NUMBER NOT NULL,
    PRICE NUMBER NOT NULL,
    SINGLE_BED_NUM NUMBER NOT NULL,
    DOUBLE_BED_NUM NUMBER NOT NULL,
    AREA NUMBER NOT NULL,
    SCENE_ID NUMBER NOT NULL,
    HOTEL_ID NUMBER NOT NULL,
    CONSTRAINT ROOM_PK PRIMARY KEY (ID),
    CONSTRAINT ROOM_FK1 FOREIGN KEY (SCENE_ID) REFERENCES SCENE (ID),
    CONSTRAINT ROOM_FK2 FOREIGN KEY (HOTEL_ID) REFERENCES HOTEL (ID)
);

COMMENT ON COLUMN ROOM.ID IS '房間編號';
COMMENT ON COLUMN ROOM.NAME IS '房間名稱';
COMMENT ON COLUMN ROOM.TOTAL_NUM IS '房間總數';
COMMENT ON COLUMN ROOM.INVALID_NUM IS '不開放房間數';
COMMENT ON COLUMN ROOM.USED_NUM IS '使用中房間數';
COMMENT ON COLUMN ROOM.PRICE IS '房間單價';
COMMENT ON COLUMN ROOM.SINGLE_BED_NUM IS '單人床數';
COMMENT ON COLUMN ROOM.DOUBLE_BED_NUM IS '雙人床數';
COMMENT ON COLUMN ROOM.AREA IS '房間面積';
COMMENT ON COLUMN ROOM.SCENE_ID IS '房間景觀編號';
COMMENT ON COLUMN ROOM.HOTEL_ID IS '所屬飯店編號';

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE ROOM_SEQ';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
CREATE SEQUENCE ROOM_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO ROOM (ID, NAME, TOTAL_NUM, INVALID_NUM, USED_NUM, PRICE, SINGLE_BED_NUM, DOUBLE_BED_NUM, AREA, SCENE_ID, HOTEL_ID) VALUES (ROOM_SEQ.NEXTVAL, '標準雙人房', 5, 1, 2, 1000, 2, 0, 13, 1, 1);
INSERT INTO ROOM (ID, NAME, TOTAL_NUM, INVALID_NUM, USED_NUM, PRICE, SINGLE_BED_NUM, DOUBLE_BED_NUM, AREA, SCENE_ID, HOTEL_ID) VALUES (ROOM_SEQ.NEXTVAL, '標準單人房', 10, 2, 5, 800, 1, 0, 13, 2, 1);
INSERT INTO ROOM (ID, NAME, TOTAL_NUM, INVALID_NUM, USED_NUM, PRICE, SINGLE_BED_NUM, DOUBLE_BED_NUM, AREA, SCENE_ID, HOTEL_ID) VALUES (ROOM_SEQ.NEXTVAL, '豪華雙人房', 8, 1, 3, 1300, 0, 1, 15, 2, 1);
INSERT INTO ROOM (ID, NAME, TOTAL_NUM, INVALID_NUM, USED_NUM, PRICE, SINGLE_BED_NUM, DOUBLE_BED_NUM, AREA, SCENE_ID, HOTEL_ID) VALUES (ROOM_SEQ.NEXTVAL, '豪華單人房', 4, 0, 2, 1200, 1, 0, 18, 3, 1);
INSERT INTO ROOM (ID, NAME, TOTAL_NUM, INVALID_NUM, USED_NUM, PRICE, SINGLE_BED_NUM, DOUBLE_BED_NUM, AREA, SCENE_ID, HOTEL_ID) VALUES (ROOM_SEQ.NEXTVAL, '特大雙人房', 4, 0, 2, 1100, 2, 0, 20, 4, 1);



-- 沐浴設備資料表
CREATE TABLE SHOWER
(
    ID NUMBER NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    CONSTRAINT SHOWER_PK PRIMARY KEY (ID),
    CONSTRAINT SHOWER_UNIQUE1 UNIQUE (NAME)
);

COMMENT ON COLUMN SHOWER.ID IS '沐浴設備編號';
COMMENT ON COLUMN SHOWER.NAME IS '沐浴設備名稱';

INSERT INTO SHOWER (ID, NAME) VALUES (1, '淋浴設備');
INSERT INTO SHOWER (ID, NAME) VALUES (2, '浴缸');
INSERT INTO SHOWER (ID, NAME) VALUES (3, '蒸氣室');



-- 房間沐浴設備聯集資料表
CREATE TABLE ROOM_SHOWER_JOIN
(
    ROOM_ID NUMBER NOT NULL,
    SHOWER_ID NUMBER NOT NULL,
    CONSTRAINT ROOM_SHOWER_JOIN_PK PRIMARY KEY (ROOM_ID, SHOWER_ID),
    CONSTRAINT ROOM_SHOWER_JOIN_FK1 FOREIGN KEY (ROOM_ID) REFERENCES ROOM (ID),
    CONSTRAINT ROOM_SHOWER_JOIN_FK2 FOREIGN KEY (SHOWER_ID) REFERENCES SHOWER (ID)
);

COMMENT ON COLUMN ROOM_SHOWER_JOIN.ROOM_ID IS '房間編號';
COMMENT ON COLUMN ROOM_SHOWER_JOIN.SHOWER_ID IS '沐浴設備編號';


INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (1, 1);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (1, 2);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (2, 1);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (2, 2);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (3, 1);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (4, 1);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (4, 2);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (5, 1);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (5, 2);
INSERT INTO ROOM_SHOWER_JOIN (ROOM_ID, SHOWER_ID) VALUES (5, 3);



-- 房間照片資料表
CREATE TABLE ROOM_IMG
(
    ID NUMBER NOT NULL,
    IMG_NAME VARCHAR2(100) NOT NULL,
    IMG_ORDER NUMBER NOT NULL,
    ROOM_ID NUMBER NOT NULL,
    CONSTRAINT ROOM_IMG_PK PRIMARY KEY (ID),
    CONSTRAINT ROOM_IMG_UNIQUE1 UNIQUE (IMG_NAME),
    CONSTRAINT ROOM_IMG_UNIQUE2 UNIQUE (IMG_ORDER, ROOM_ID),
    CONSTRAINT ROOM_IMG_FK1 FOREIGN KEY (ROOM_ID) REFERENCES ROOM (ID)
);

COMMENT ON COLUMN ROOM_IMG.ID IS '房間照片編號';
COMMENT ON COLUMN ROOM_IMG.IMG_NAME IS '房間照片檔名';
COMMENT ON COLUMN ROOM_IMG.IMG_ORDER IS '房間照片順序';
COMMENT ON COLUMN ROOM_IMG.ROOM_ID IS '所屬房間';

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE ROOM_IMG_SEQ';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
CREATE SEQUENCE ROOM_IMG_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO ROOM_IMG (ID, IMG_NAME, IMG_ORDER, ROOM_ID) VALUES (ROOM_IMG_SEQ.NEXTVAL, 'img1.jpg', 1, 1);
INSERT INTO ROOM_IMG (ID, IMG_NAME, IMG_ORDER, ROOM_ID) VALUES (ROOM_IMG_SEQ.NEXTVAL, 'img2.jpg', 2, 1);
INSERT INTO ROOM_IMG (ID, IMG_NAME, IMG_ORDER, ROOM_ID) VALUES (ROOM_IMG_SEQ.NEXTVAL, 'img3.jpg', 1, 2);
INSERT INTO ROOM_IMG (ID, IMG_NAME, IMG_ORDER, ROOM_ID) VALUES (ROOM_IMG_SEQ.NEXTVAL, 'img4.jpg', 2, 2);
INSERT INTO ROOM_IMG (ID, IMG_NAME, IMG_ORDER, ROOM_ID) VALUES (ROOM_IMG_SEQ.NEXTVAL, 'img5.jpg', 3, 2);
INSERT INTO ROOM_IMG (ID, IMG_NAME, IMG_ORDER, ROOM_ID) VALUES (ROOM_IMG_SEQ.NEXTVAL, 'img6.jpg', 1, 3);
INSERT INTO ROOM_IMG (ID, IMG_NAME, IMG_ORDER, ROOM_ID) VALUES (ROOM_IMG_SEQ.NEXTVAL, 'img7.jpg', 2, 3);




-- 會員資料表
CREATE TABLE MEMBER
(
    ID NUMBER NOT NULL,
    ACCOUNT VARCHAR2(50) NOT NULL,
    PASSWORD VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE VARCHAR2(15),
    CONSTRAINT MEMBER_PK PRIMARY KEY (ID),
    CONSTRAINT MEMBER_UNIQUE1 UNIQUE (ACCOUNT)
);

COMMENT ON COLUMN MEMBER.ID IS '會員編號';
COMMENT ON COLUMN MEMBER.ACCOUNT IS '會員帳號';
COMMENT ON COLUMN MEMBER.PASSWORD IS '會員密碼';
COMMENT ON COLUMN MEMBER.NAME IS '會員名稱';
COMMENT ON COLUMN MEMBER.PHONE IS '手機號碼';

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE MEMBER_SEQ';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
CREATE SEQUENCE MEMBER_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO MEMBER (ID, ACCOUNT, PASSWORD, NAME, PHONE) VALUES (MEMBER_SEQ.NEXTVAL, 'ZZZ123', '123456', 'Wendy', '0912345678');
INSERT INTO MEMBER (ID, ACCOUNT, PASSWORD, NAME) VALUES (MEMBER_SEQ.NEXTVAL, 'QQQ123', '123456', 'Bob');
INSERT INTO MEMBER (ID, ACCOUNT, PASSWORD, NAME, PHONE) VALUES (MEMBER_SEQ.NEXTVAL, 'YYY123', '123456', 'Tiffany', '0934567890');
INSERT INTO MEMBER (ID, ACCOUNT, PASSWORD, NAME) VALUES (MEMBER_SEQ.NEXTVAL, 'XXX123', '123456', 'Tom');
INSERT INTO MEMBER (ID, ACCOUNT, PASSWORD, NAME, PHONE) VALUES (MEMBER_SEQ.NEXTVAL, 'TTT123', '123456', 'Joy', '0956789012');



-- 付款方式資料表
CREATE TABLE PAY_METHOD
(
    ID NUMBER NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    CONSTRAINT PAY_METHOD_PK PRIMARY KEY (ID),
    CONSTRAINT PAY_METHOD_UNIQUE1 UNIQUE (NAME)
);

COMMENT ON COLUMN PAY_METHOD.ID IS '付款方式編號';
COMMENT ON COLUMN PAY_METHOD.NAME IS '付款方式名稱';

INSERT INTO PAY_METHOD (ID, NAME) VALUES (1, '現金');
INSERT INTO PAY_METHOD (ID, NAME) VALUES (2, '信用卡');



-- 訂單資料表
CREATE TABLE BOOKING_ORDER
(
    ID NUMBER NOT NULL,
    CLIENT_ID NUMBER NOT NULL,
    ROOM_ID NUMBER NOT NULL,
    ROOM_NUM NUMBER NOT NULL,
    PAY_METHOD_ID NUMBER NOT NULL,
    CHECKIN_DATETIME DATE NOT NULL,
    CHECKOUT_DATE DATE NOT NULL,
    USE_DAY NUMBER NOT NULL,
    TOTAL_MONEY NUMBER NOT NULL,
    CONSTRAINT BOOKING_ORDER_PK PRIMARY KEY (ID),
    CONSTRAINT BOOKING_ORDER_FK1 FOREIGN KEY (CLIENT_ID) REFERENCES MEMBER (ID),
    CONSTRAINT BOOKING_ORDER_FK2 FOREIGN KEY (ROOM_ID) REFERENCES ROOM (ID),
    CONSTRAINT BOOKING_ORDER_FK3 FOREIGN KEY (PAY_METHOD_ID) REFERENCES PAY_METHOD (ID)
);

COMMENT ON COLUMN BOOKING_ORDER.ID IS '訂單編號';
COMMENT ON COLUMN BOOKING_ORDER.CLIENT_ID IS '會員編號';
COMMENT ON COLUMN BOOKING_ORDER.ROOM_ID IS '房間編號';
COMMENT ON COLUMN BOOKING_ORDER.ROOM_NUM IS '預定房間數量';
COMMENT ON COLUMN BOOKING_ORDER.PAY_METHOD_ID IS '付款方式編號';
COMMENT ON COLUMN BOOKING_ORDER.CHECKIN_DATETIME IS '預定入住日期時辰';
COMMENT ON COLUMN BOOKING_ORDER.CHECKOUT_DATE IS '預定退房日期';
COMMENT ON COLUMN BOOKING_ORDER.USE_DAY IS '入住天數';
COMMENT ON COLUMN BOOKING_ORDER.TOTAL_MONEY IS '總金額';

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE BOOKING_ORDER_SEQ';
    EXCEPTION
        WHEN OTHERS THEN NULL;
END;
/
CREATE SEQUENCE BOOKING_ORDER_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

INSERT INTO BOOKING_ORDER (ID, CLIENT_ID, ROOM_ID, ROOM_NUM, PAY_METHOD_ID, CHECKIN_DATETIME, CHECKOUT_DATE, USE_DAY, TOTAL_MONEY) VALUES (BOOKING_ORDER_SEQ.NEXTVAL, 1, 1, 1, 1, TO_DATE ('2023-04-20 17:00', 'YYYY-MM-DD HH24:MI'), TO_DATE ('2023-04-21', 'YYYY-MM-DD'), 1, 1000);
INSERT INTO BOOKING_ORDER (ID, CLIENT_ID, ROOM_ID, ROOM_NUM, PAY_METHOD_ID, CHECKIN_DATETIME, CHECKOUT_DATE, USE_DAY, TOTAL_MONEY) VALUES (BOOKING_ORDER_SEQ.NEXTVAL, 2, 2, 1, 2, TO_DATE ('2023-04-17 20:30', 'YYYY-MM-DD HH24:MI'), TO_DATE ('2023-04-19', 'YYYY-MM-DD'), 2, 2000);
INSERT INTO BOOKING_ORDER (ID, CLIENT_ID, ROOM_ID, ROOM_NUM, PAY_METHOD_ID, CHECKIN_DATETIME, CHECKOUT_DATE, USE_DAY, TOTAL_MONEY) VALUES (BOOKING_ORDER_SEQ.NEXTVAL, 3, 3, 1, 1, TO_DATE ('2023-04-16 15:30', 'YYYY-MM-DD HH24:MI'), TO_DATE ('2023-04-17', 'YYYY-MM-DD'), 1, 1000);
INSERT INTO BOOKING_ORDER (ID, CLIENT_ID, ROOM_ID, ROOM_NUM, PAY_METHOD_ID, CHECKIN_DATETIME, CHECKOUT_DATE, USE_DAY, TOTAL_MONEY) VALUES (BOOKING_ORDER_SEQ.NEXTVAL, 4, 4, 2, 1, TO_DATE ('2023-04-21 22:00', 'YYYY-MM-DD HH24:MI'), TO_DATE ('2023-04-23', 'YYYY-MM-DD'), 2, 1600);
INSERT INTO BOOKING_ORDER (ID, CLIENT_ID, ROOM_ID, ROOM_NUM, PAY_METHOD_ID, CHECKIN_DATETIME, CHECKOUT_DATE, USE_DAY, TOTAL_MONEY) VALUES (BOOKING_ORDER_SEQ.NEXTVAL, 5, 5, 1, 2, TO_DATE ('2023-04-10 16:00', 'YYYY-MM-DD HH24:MI'), TO_DATE ('2023-04-15', 'YYYY-MM-DD'), 5, 5000);


COMMIT;