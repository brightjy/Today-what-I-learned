-- Dept.xml id=deptList
SELECT*FROM DEPT;

-- Emp.xml id=empList
SELECT*FROM EMP ORDER BY EMPNO; -- 기준
SELECT*FROM(SELECT ROWNUM RN, A.* FROM(SELECT*FROM EMP ORDER BY EMPNO) A) WHERE RN BETWEEN 2 AND 5;

-- Emp.xml id=total
SELECT COUNT(*) FROM EMP;

-- Emp.xml id=detail
SELECT*FROM EMP WHERE EMPNO=7566;

-- Emp.xml id=managerList
SELECT*FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);

-- Emp.xml id=insert
INSERT INTO EMP VALUES (1111, 'TESTNAME', 'TESTJOB', 1111, '2020-03-03', 1111, 1111, 10);

-- Emp.xml id=update
UPDATE EMP SET ENAME='MODIFYNAME', 
                JOB='MODIFYJOB',
                MGR=7839,
                HIREDATE=SYSDATE,
                SAL=8000,
                COMM=900,
                DEPTNO=20
            WHERE EMPNO=1111;    

-- Emp.xml id=delete
DELETE FROM EMP WHERE EMPNO=1111; 

-- EmpDept.xml id=empDeptList
SELECT E.*, DNAME, LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO ORDER BY EMPNO; -- 기준
SELECT*FROM (SELECT ROWNUM RN, A.* FROM 
    (SELECT E.*, DNAME, LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO ORDER BY EMPNO) A) 
        WHERE RN BETWEEN 2 AND 5;