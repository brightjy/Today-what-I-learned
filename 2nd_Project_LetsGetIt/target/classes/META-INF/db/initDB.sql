----------------------------------------
---            멤버 관련              ---
----------------------------------------
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER( 
    mID      VARCHAR2(50),
    mPW      VARCHAR2(50)  NOT NULL,
    mNAME    VARCHAR2(50)  NOT NULL,
    mPHONE   VARCHAR2(100) NOT NULL,
    mEMAIL   VARCHAR2(100) NOT NULL,
    mPOST    VARCHAR2(50),
    mADDRESS VARCHAR2(1000),
    mBIRTH   DATE,
    mRDATE   DATE DEFAULT SYSDATE NOT NULL,
    mImg    VARCHAR2(1000),
    PRIMARY KEY(mID)
);
SELECT*FROM MEMBER;
----------------------------------------
---            호스트 관련            ---
----------------------------------------
DROP TABLE HOST CASCADE CONSTRAINTS;
DROP TABLE LIKE_HOST;
DROP SEQUENCE LIKE_HOST_SEQ;

CREATE TABLE HOST(
    hID VARCHAR2(50) PRIMARY KEY,
    hPW VARCHAR2(50) NOT NULL,
    hNAME VARCHAR2(50) NOT NULL,
    hPHONE VARCHAR2(100) NOT NULL,
    hEMAIL VARCHAR2(100) NOT NULL,
    hRDATE DATE DEFAULT SYSDATE NOT NULL,
    hBLACK NUMBER(1) DEFAULT 0 NOT NULL,
    hPOST VARCHAR2(50),
    hADDRESS VARCHAR2(4000),
    hCNTLIKE NUMBER(4) DEFAULT 0 NOT NULL
);

CREATE TABLE LIKE_HOST(
    lhID NUMBER(7) PRIMARY KEY,
    mID VARCHAR2(50) REFERENCES MEMBER(mID),
    hID VARCHAR2(50) REFERENCES HOST(hID)
);

CREATE SEQUENCE LIKE_HOST_SEQ MAXVALUE 9999999 NOCYCLE NOCACHE;

COMMIT;
