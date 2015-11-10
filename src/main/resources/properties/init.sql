CREATE TABLE public.city (
  city_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('city_city_id_seq'::regclass),
  city_name CHARACTER VARYING(50) NOT NULL,
  country_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX unique_city_id ON city USING BTREE (city_id);
DROP SEQUENCE public.city_city_id_seq RESTRICT;
CREATE SEQUENCE public.city_city_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;


CREATE TABLE public.country (
  country_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('country_country_id_seq'::regclass),
  country_name CHARACTER VARYING(50) NOT NULL,
  county_iso_code CHARACTER VARYING(10) NOT NULL
);
CREATE UNIQUE INDEX unique_country_id ON country USING BTREE (country_id);
DROP SEQUENCE public.country_country_id_seq RESTRICT;
CREATE SEQUENCE public.country_country_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
