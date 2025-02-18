-- Table: public.contracts

-- DROP TABLE IF EXISTS public.contracts;

CREATE TABLE IF NOT EXISTS public.contracts
(
    id bigint NOT NULL DEFAULT nextval('contract_id_seq'::regclass),
    contract_key character varying(255) COLLATE pg_catalog."default" NOT NULL,
    contract_link_id bigint COLLATE pg_catalog."defualt" NOT NULL,
    contract_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    contract_kana character varying(255) COLLATE pg_catalog."default" NOT NULL,
    contract_start_date date,
    contract_date date,
    contract_limit date,
    zip character varying(255) COLLATE pg_catalog."default",
    pref character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    other_address character varying(255) COLLATE pg_catalog."default",
    tel character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    create_user bigint,
    update_user bigint,
    delete_user bigint,
    create_date timestamp with time zone,
    update_date timestamp with time zone,
    delete_date timestamp with time zone,
    CONSTRAINT contract_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contracts
    OWNER to postgres;

COMMENT ON COLUMN public.contracts.id
    IS 'プライマリキー';

COMMENT ON COLUMN public.contracts.contract_key
    IS '契約KEY';

COMMENT ON COLUMN public.contracts.contract_name
    IS '契約者名称';

COMMENT ON COLUMN public.contracts.contract_kana
    IS '契約者名称カナ';

COMMENT ON COLUMN public.contracts.contract_start_date
    IS '初回契約日';

COMMENT ON COLUMN public.contracts.contract_date
    IS '契約開始日';

COMMENT ON COLUMN public.contracts.contract_limit
    IS '契約終了日';

COMMENT ON COLUMN public.contracts.zip
    IS '郵便番号';

COMMENT ON COLUMN public.contracts.pref
    IS '都道府県コード';

COMMENT ON COLUMN public.contracts.city
    IS '市区町村名';

COMMENT ON COLUMN public.contracts.address
    IS '番地';

COMMENT ON COLUMN public.contracts.other_address
    IS 'その他住所';

COMMENT ON COLUMN public.contracts.tel
    IS '連絡先電話番号';

COMMENT ON COLUMN public.contracts.email
    IS '連絡先メールアドレス';

COMMENT ON COLUMN public.contracts.create_user
    IS '登録ユーザID';

COMMENT ON COLUMN public.contracts.update_user
    IS '更新ユーザID';

COMMENT ON COLUMN public.contracts.delete_user
    IS '削除ユーザID';

COMMENT ON COLUMN public.contracts.create_date
    IS '登録年月日';

COMMENT ON COLUMN public.contracts.update_date
    IS '更新年月日';

COMMENT ON COLUMN public.contracts.delete_date
    IS '削除年月日';
