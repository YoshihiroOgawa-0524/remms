-- Table: public.customers

-- DROP TABLE IF EXISTS public.customers;

CREATE TABLE IF NOT EXISTS public.customers
(
    id integer NOT NULL DEFAULT nextval('customers_id_seq'::regclass),
    customer_name character varying(64) COLLATE pg_catalog."default" NOT NULL,
    customer_kana character varying(64) COLLATE pg_catalog."default" NOT NULL,
    zip_cd character(7) COLLATE pg_catalog."default",
    pref_cd character(2) COLLATE pg_catalog."default",
    address_1 character varying(64) COLLATE pg_catalog."default",
    address_2 character varying(64) COLLATE pg_catalog."default",
    phone_no character varying(16) COLLATE pg_catalog."default",
    fax_no character varying(16) COLLATE pg_catalog."default",
    mobile_phone character varying(16) COLLATE pg_catalog."default",
    medium_cd integer,
    birthday date,
    email character varying(128) COLLATE pg_catalog."default",
    compny_cd integer,
    memo text COLLATE pg_catalog."default",
    create_date date,
    update_date date,
    delete_date date,
    create_user integer,
    update_user integer,
    delete_user integer,
    CONSTRAINT customers_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customers
    OWNER to postgres;