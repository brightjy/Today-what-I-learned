-- DEPT.XML (ID:deptList)
SELECT*FROM DEPT;

-- EMP.XML (ID:empList)
SELECT*FROM EMP 
    WHERE ENAME LIKE '%'||'A'||'%'
    AND JOB LIKE '%'||'E'||'%'
    AND DEPTNO = 20;