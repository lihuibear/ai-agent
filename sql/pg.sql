CREATE DATABASE agent;
CREATE EXTENSION IF NOT EXISTS vector;
-- 若表不存在或字段类型错误，需重新创建表（示例SQL）
CREATE TABLE IF NOT EXISTS public.vector_store (
                                                   id UUID PRIMARY KEY,
                                                   content TEXT,
                                                   metadata JSONB,
                                                   embedding vector(1536)
);
DROP DATABASE IF EXISTS agent;
