CREATE TABLE IF NOT EXISTS t_courses
(
    course_id bigint NOT NULL,
    title text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    steps_json json,
    allow_enrollments boolean NOT NULL,
    updated_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    created_by bigint NOT NULL,
    CONSTRAINT t_courses_pkey PRIMARY KEY (course_id)
)

TABLESPACE pg_default;

ALTER TABLE t_courses
    OWNER to ${flyway:user};

COMMENT ON TABLE t_courses
    IS 'Holds Course related information';

