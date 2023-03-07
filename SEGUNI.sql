





alter session set "_ORACLE_SCRIPT"=true;
create user SEGUNI identified by SEGUNI;
GRANT ALL PRIVILEGES TO SEGUNI;


select * from cliente;
select * from compania;
select * from compania_seguro;
select * from perito;
select * from seguro;
select * from siniestro;
select * from user_login;


delete from cliente;
delete from compania;
delete from compania_seguro;
delete from perito;
delete from seguro;
delete from siniestro;
delete from user_login;commit;

drop table seguni.cliente cascade constraints;
drop table seguni.compania cascade constraints;
drop table seguni.compania_seguro cascade constraints;
drop table seguni.perito cascade constraints;
drop table seguni.seguro cascade constraints;
drop table seguni.siniestro cascade constraints;
drop table seguni.user_login cascade constraints;commit;

drop sequence seguni.compania_seguro_seq;
drop sequence seguni.seguro_seq;
drop sequence seguni.siniestro_seq;commit;


create sequence seguni.compania_seguro_seq start with 1 increment by 1;
create sequence seguni.seguro_seq start with 1 increment by 1;
create sequence seguni.siniestro_seq start with 1 increment by 1;commit;

 
create table seguni.cliente (
       dni_cl varchar2(13 char) not null,
        apellido_1 varchar2(255 char),
        apellido_2 varchar2(255 char),
        ciudad varchar2(255 char),
        clase_via varchar2(255 char),
        codigo_postal varchar2(255 char),
        nombre_cl varchar2(255 char),
        nombre_via varchar2(255 char),
        numero_via number(19,0),
        observaciones varchar2(255 char),
        telefono varchar2(255 char),
        primary key (dni_cl)
)
create table seguni.compania (
       nombre_compania varchar2(255 char) not null,
        clase_via varchar2(255 char),
        codigo_postal varchar2(255 char),
        nombre_via varchar2(255 char),
        notas varchar2(255 char),
        numero_via varchar2(255 char),
        telefono_contratacion varchar2(255 char),
        telefono_siniestro varchar2(255 char),
        primary key (nombre_compania)
)
create table seguni.compania_seguro (
       id number(19,0) not null,
        nombre_compania varchar2(255 char),
        numero_poliza number(19,0),
        primary key (id)
)
create table seguni.perito (
       dni_perito varchar2(255 char) not null,
        apellido_perito_1 varchar2(255 char),
        apellido_perito_2 varchar2(255 char),
        calle_via varchar2(255 char),
        ciudad varchar2(255 char),
        codigo_postal varchar2(255 char),
        nombre_perito varchar2(255 char),
        nombre_via varchar2(255 char),
        numero_via number(19,0),
        telefono_contacto varchar2(255 char),
        telefono_oficina varchar2(255 char),
        primary key (dni_perito)
)
create table seguni.seguro (
       numero_poliza number(19,0) not null,
        condiciones_particulares varchar2(255 char),
        dni_cl varchar2(255 char),
        fecha_inicio timestamp(6),
        fecha_vencimiento timestamp(6),
        observaciones varchar2(255 char),
        ramo varchar2(255 char),
        primary key (numero_poliza)
)
create table seguni.siniestro (
       id_siniestro number(19,0) not null,
        aceptado varchar2(255 char),
        causas varchar2(255 char),
        fecha_siniestro varchar2(255 char),
        indemnizacion float(53),
        perito_dni_perito varchar2(255 char),
        seguro_numero_poliza number(19,0),
        primary key (id_siniestro)
)
create table compania_seguro (
       nombre_compania varchar2(255 char) not null,
        numero_poliza number(19,0) not null
)
create table seguni.user_login (
       usuario varchar2(255 char) not null,
        contrasena varchar2(255 char),
        primary key (usuario)
)
alter table seguni.siniestro 
       add constraint FKpjj1ow4cjm9pkg9nq61lqcl00 
       foreign key (perito_dni_perito) 
       references seguni.perito
alter table seguni.siniestro 
       add constraint FKdlrmjievqaaticl2c96167ckq 
       foreign key (seguro_numero_poliza) 
       references seguni.seguro
alter table compania_seguro 
       add constraint FKtr7bixag9pext9ek0kqlxr861 
       foreign key (numero_poliza) 
       references seguni.seguro
alter table compania_seguro 
       add constraint FKsblcv22e25wcnyd0ebu2g1c4t 
       foreign key (nombre_compania) 
       references seguni.compania
       
       

















create or replace NONEDITIONABLE PACKAGE mipack IS
 FUNCTION funciony(
 numA IN OUT NUMBER,
 numB IN NUMBER,
 estatus OUT VARCHAR2) RETURN DATE;
 
 PROCEDURE procedimientoy(
 numA IN OUT NUMBER,
 numB IN NUMBER,
 estatus OUT VARCHAR2 );
END mipack;
create or replace NONEDITIONABLE PACKAGE BODY mipack IS
FUNCTION funciony(
 numA IN OUT NUMBER,
 numB IN NUMBER,
 estatus OUT VARCHAR2) RETURN DATE
IS BEGIN

if numB > 50 then
 estatus := 'Ok';
 numA := (numA + numB) * 2;
else
 estatus := 'Error';
 numA := -1;
end if;

RETURN SYSDATE;

END funciony;

PROCEDURE procedimientoy(
 numA IN OUT  NUMBER,
 numB IN NUMBER,
 estatus OUT VARCHAR2) AS BEGIN
    numA := numA + numB;
    estatus := 'Actualizado';
END;
END mipack;







create or replace NONEDITIONABLE PACKAGE paquete IS
    FUNCTION funcionx(texto IN OUT VARCHAR2,
                    numero IN NUMBER,
                    salida OUT VARCHAR2) RETURN DATE;
END paquete;
create or replace NONEDITIONABLE PACKAGE BODY paquete IS
    FUNCTION funcionx(texto IN OUT VARCHAR2,
                    numero IN NUMBER,
                    salida OUT VARCHAR2) RETURN DATE
    IS
        BEGIN
        IF numero = 1 THEN
            texto := 'ingresado numero 1';
        ELSE 
            texto := 'texto modificado en funcion';
        END IF;    
        salida := 'funcion ejecutada correctamente';
        RETURN sysdate;

    END funcionx;
END paquete;

















