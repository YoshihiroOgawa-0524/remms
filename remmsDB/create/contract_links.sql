-- Table: public.contract_links

-- DROP TABLE IF EXISTS public.contract_links;

CREATE TABLE IF NOT EXISTS public.contract_links
(
    id integer NOT NULL DEFAULT nextval('contract_links_id_seq'::regclass),
    contract_id integer,
    contract_type_id integer,
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