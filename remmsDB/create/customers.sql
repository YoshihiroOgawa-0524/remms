-- Table: public.customers

-- DROP TABLE IF EXISTS public.customers;

CREATE TABLE IF NOT EXISTS public.customers
(
    id integer NOT NULL DEFAULT nextval('customers_id_seq'::regclass),
    contract_id bigint NOT NULL,
    customer_name character varying(64) COLLATE pg_catalog."default" NOT NULL,
    customer_kana character varying(64) COLLATE pg_catalog."default" NOT NULL,
    zip character(7) COLLATE pg_catalog."default",
    pref_cd character(2) COLLATE pg_catalog."default",
    city character varying(64) COLLATE pg_catalog."default",
    address character varying(64) COLLATE pg_catalog."default",
    other_address character varying(64) COLLATE pg_catalog."default",
    birthday date,
    email character varying(255) COLLATE pg_catalog."default",
    phone_no character varying(16) COLLATE pg_catalog."default",
    fax_no character varying(16) COLLATE pg_catalog."default",
    mobile_phone character varying(16) COLLATE pg_catalog."default",
    company_id bigint,
    medium_id bigint,
    memo text COLLATE pg_catalog."default",
    create_date timestamp with time zone,
    update_date timestamp with time zone,
    delete_date timestamp with time zone,
    create_user bigint,
    update_user bigint,
    delete_user bigint,
    CONSTRAINT customers_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customers
    OWNER to postgres;

COMMENT ON COLUMN public.customers.id
    IS 'プライマリキー';

COMMENT ON COLUMN public.customers.contract_id
    IS '契約ID';

COMMENT ON COLUMN public.customers.customer_name
    IS '顧客名称';

COMMENT ON COLUMN public.customers.customer_kana
    IS '顧客名称カナ';

COMMENT ON COLUMN public.customers.zip
    IS '郵便番号';

COMMENT ON COLUMN public.customers.pref_cd
    IS '都道府県コード';

COMMENT ON COLUMN public.customers.city
    IS '市区町村名';

COMMENT ON COLUMN public.customers.address
    IS '番地';

COMMENT ON COLUMN public.customers.other_address
    IS 'その他住所';

COMMENT ON COLUMN public.customers.birthday
    IS '誕生日';

COMMENT ON COLUMN public.customers.email
    IS 'メールアドレス';

COMMENT ON COLUMN public.customers.phone_no
    IS '固定電話';

COMMENT ON COLUMN public.customers.fax_no
    IS 'FAX';

COMMENT ON COLUMN public.customers.mobile_phone
    IS '携帯電話';

COMMENT ON COLUMN public.customers.company_id
    IS '会社ID';

COMMENT ON COLUMN public.customers.medium_id
    IS '役職ID';

COMMENT ON COLUMN public.customers.memo
    IS '備考';

COMMENT ON COLUMN public.customers.create_date
    IS '登録日時';

COMMENT ON COLUMN public.customers.update_date
    IS '更新日時';

COMMENT ON COLUMN public.customers.delete_date
    IS '削除日時';

COMMENT ON COLUMN public.customers.create_user
    IS '登録ユーザ';

COMMENT ON COLUMN public.customers.update_user
    IS '更新ユーザ';

COMMENT ON COLUMN public.customers.delete_user
    IS '削除ユーザ';