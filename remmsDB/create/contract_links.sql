-- Table: public.contract_links

-- DROP TABLE IF EXISTS public.contract_links;

CREATE TABLE IF NOT EXISTS public.contract_links
(
    id integer NOT NULL,
    contract_id bigint,
    contract_type_id bigint,
    CONSTRAINT contract_links_pkey PRIMARY KEY (id),
    CONSTRAINT fk6rjx09u06xyh6qead0oitg70u FOREIGN KEY (contract_id)
        REFERENCES public.contracts (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkfmu4lhas6y9lckqm7x5qt39c0 FOREIGN KEY (contract_type_id)
        REFERENCES public.contract_types (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contract_links
    OWNER to postgres;

COMMENT ON COLUMN public.contract_links.id
    IS 'プライマリキー';

COMMENT ON COLUMN public.contract_links.contract_id
    IS '契約ID';

COMMENT ON COLUMN public.contract_links.contract_type_id
    IS '契約タイプID';