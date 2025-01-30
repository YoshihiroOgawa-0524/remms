-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    user_id character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name_kana character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    type integer,
    contract_id integer,
    create_date character varying(255) COLLATE pg_catalog."default",
    update_date character varying(255) COLLATE pg_catalog."default",
    delete_date character varying(255) COLLATE pg_catalog."default",
    create_user integer,
    update_user integer,
    delete_user integer,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT fk8vn153dgcpy1edg0wi3asibd0 FOREIGN KEY (contract_id)
        REFERENCES public.contracts (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;