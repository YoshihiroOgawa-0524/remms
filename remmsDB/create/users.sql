-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    user_id character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name_kana character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    type integer,
    contract_id bigint,
    contract_key character varying(255) COLLATE pg_catalog."default",
    create_date timestamp with time zone,
    update_date timestamp with time zone,
    delete_date timestamp with time zone,
    create_user bigint,
    update_user bigint,
    delete_user bigint,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT fk8vn153dgcpy1edg0wi3asibd0 FOREIGN KEY (contract_id)
        REFERENCES public.contracts (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

COMMENT ON COLUMN public.users.id
    IS 'プライマリキー';

COMMENT ON COLUMN public.users.name
    IS '氏名';

COMMENT ON COLUMN public.users.name_kana
    IS '氏名カナ';

COMMENT ON COLUMN public.users.password
    IS 'パスワード';

COMMENT ON COLUMN public.users.create_user
    IS '登録ユーザ';

COMMENT ON COLUMN public.users.update_user
    IS '更新ユーザ';

COMMENT ON COLUMN public.users.delete_user
    IS '削除ユーザ';

COMMENT ON COLUMN public.users.type
    IS 'ユーザタイプ';

COMMENT ON COLUMN public.users.contract_key
    IS '契約キー';

COMMENT ON COLUMN public.users.user_id
    IS 'ユーザID';

COMMENT ON COLUMN public.users.contract_id
    IS '契約ID';

COMMENT ON COLUMN public.users.create_date
    IS '登録日時';

COMMENT ON COLUMN public.users.update_date
    IS '更新日時';

COMMENT ON COLUMN public.users.delete_date
    IS '削除日時';