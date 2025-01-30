-- Table: public.contract_types

-- DROP TABLE IF EXISTS public.contract_types;

CREATE TABLE IF NOT EXISTS public.contract_types
(
    id integer NOT NULL DEFAULT nextval('contract_type_id_seq'::regclass),
    type_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    memo character varying(255) COLLATE pg_catalog."default",
    create_date character varying(255) COLLATE pg_catalog."default",
    update_date character varying(255) COLLATE pg_catalog."default",
    delete_date character varying(255) COLLATE pg_catalog."default",
    create_user integer,
    update_user integer,
    delete_user integer,
    CONSTRAINT contract_type_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contract_types
    OWNER to postgres;