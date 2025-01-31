-- Table: public.contracts

-- DROP TABLE IF EXISTS public.contracts;

CREATE TABLE IF NOT EXISTS public.contracts
(
    id integer NOT NULL DEFAULT nextval('contract_id_seq'::regclass),
    contract_key character varying(255) COLLATE pg_catalog."default" NOT NULL,
    contract_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    contract_kana character varying(255) COLLATE pg_catalog."default" NOT NULL,
    contract_date character varying(255) COLLATE pg_catalog."default",
    zip character varying(255) COLLATE pg_catalog."default",
    pref character varying(255) COLLATE pg_catalog."default",
    address_1 character varying(256) COLLATE pg_catalog."default",
    address_2 character varying(256) COLLATE pg_catalog."default",
    tel character varying(255) COLLATE pg_catalog."default",
    create_date character varying(255) COLLATE pg_catalog."default",
    update_date character varying(255) COLLATE pg_catalog."default",
    delete_date character varying(255) COLLATE pg_catalog."default",
    create_user integer,
    update_user integer,
    delete_user integer,
    CONSTRAINT contract_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contracts
    OWNER to postgres;