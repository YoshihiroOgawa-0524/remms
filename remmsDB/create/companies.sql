-- Table: public.companies

-- DROP TABLE IF EXISTS public.companies;

CREATE TABLE IF NOT EXISTS public.companies
(
    id integer NOT NULL DEFAULT nextval('companies_id_seq'::regclass),
    company_name character varying(64) COLLATE pg_catalog."default" NOT NULL,
    company_kana character varying(128) COLLATE pg_catalog."default" NOT NULL,
    zip_cd character(7) COLLATE pg_catalog."default",
    pref_cd character(2) COLLATE pg_catalog."default",
    address_1 character varying(64) COLLATE pg_catalog."default",
    address_2 character varying(64) COLLATE pg_catalog."default",
    tel_no character(16) COLLATE pg_catalog."default",
    fax_no character varying(16) COLLATE pg_catalog."default",
    department character varying(64) COLLATE pg_catalog."default",
    post character varying(64) COLLATE pg_catalog."default",
    create_date date,
    update_date date,
    delete_date date,
    create_user integer,
    update_user integer,
    delete_user integer,
    CONSTRAINT companies_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.companies
    OWNER to postgres;