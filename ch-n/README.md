# ch-n

## Parts

### base & structure

#### base

##### base - resources
* [Table parts](https://clickhouse.com/docs/parts)
* [Table shards and replicas](https://clickhouse.com/docs/shards)
* [Architecture Overview](https://clickhouse.com/docs/development/architecture)
* [ClickHouse Basic Tutorial: An Introduction](https://dev.to/hoptical/clickhouse-basic-tutorial-an-introduction-52il)
* [Заметки про ClickHouse. Tutorial 101 — Большая подборка информации](https://ivan-shamaev.ru/clickhouse-101-course-on-learn-clickhouse-com/)
* [Clickhouse + репликация + шардинг](http://iakovlev.org/index.html?p=1435)
* [Using ClickHouse Keeper for Replication](https://mrkaran.dev/posts/clickhouse-replication/)
* https://github.com/TheraniAA/clickhouse-sharded-replicated-docker-keeper/tree/main
* [ClickHouse Cluster Docker Compose](https://github.com/linsoss/clickhouse-cluster-docker/tree/master)
* [Sharding in ClickHouse: Part 1](https://chistadata.com/sharding-in-clickhouse-part-1/)
* [Clickhouse + Zookeeper](https://github.com/TanVD/ClickhouseCluster_DockerCompose/tree/master)
* https://github.com/tetafro/clickhouse-cluster/tree/master

#### syntax & statements
##### syntax & statements - resources
* [Syntax](https://clickhouse.com/docs/sql-reference/syntax)
* [Data Types in ClickHouse](https://clickhouse.com/docs/sql-reference/data-types)
* [Statements](https://clickhouse.com/docs/sql-reference/statements)

#### engines
##### engines - resources
* [ReplacingMergeTree](https://clickhouse.com/docs/engines/table-engines/mergetree-family/replacingmergetree)
* [ClickHouse Basic Tutorial: Table Engines](https://dev.to/hoptical/clickhouse-basic-tutorial-table-engines-30i1)

#### structure

Sql for creating t_pt_prop_v1.
```
CREATE TABLE IF NOT EXISTS t_pt_prop_v1 ON CLUSTER core
(
  group String,
  name String,
  date DateTime,
  created DateTime,
  value_array Array(Nullable(String)),
  value_boolean Nullable(Bool),
  value_datetime Nullable(DateTime),
  value_double Nullable(Float64),
  value_long Nullable(Int64),
  value_string Nullable(String)
)
ENGINE = ReplicatedReplacingMergeTree
ORDER BY (group, name, date);
```

Inserting to t_pt_prop_v1. 
```
INSERT INTO t_pt_prop_v1 (group, name, date, created, value_array, value_boolean, value_datetime, value_double, value_long, value_string)
SELECT
    'thing_1' as group,
    'vol' as name,
    addSeconds(parseDateTime('2025-07-01T00:00:00', '%Y-%m-%dT%H:%i:%s'), toInt32(number)) as date, 
    addSeconds(parseDateTime('2025-07-01T00:00:00', '%Y-%m-%dT%H:%i:%s'), toInt32(number)) as created, 
    [] as value_array,
    NULL as value_boolean,
    NULL as value_datetime,
    toFloat64(number) as value_double,
    NULL as value_long,
    NULL as value_string
FROM numbers(10)
;
```

Examples.
```
SELECT * FROM t_pt_prop_v1;

SELECT count(*) FROM t_pt_prop_v1;
```

### design & queries

#### design
##### design - resources
* [Schema Design](https://clickhouse.com/docs/data-modeling/schema-design)

#### deployment & architecture
##### deployment & architecture - resources
* [Deployment and Scaling](https://clickhouse.com/docs/architecture/introduction)

#### queries
##### queries - resources
* [Advanced Tutorial](https://github.com/ClickHouse/clickhouse-docs/blob/main/docs/tutorial.md)
* [A simple guide for query optimization](https://github.com/ClickHouse/clickhouse-docs/blob/main/docs/guides/best-practices/query-optimization.md)
* [Advanced Tutorial](https://clickhouse.com/docs/tutorial)

#### functions
##### functions - resources
* [Functions](https://clickhouse.com/docs/sql-reference/functions)

#### explain

```
EXPLAIN [
    AST |        
    SYNTAX |    
    PLAN* |        
    PIPELINE |    
    ESTIMATE    
]
SELECT ...
```

```
AST - абстрактное синтаксическое дерево запроса.
SYNTAX - текст запроса после оптимизации на уровне синтаксического дерева.
PLAN - план выполнения запроса, является модификатором поведения по умолчанию и используется, даже если не указан.
PIPELINE - последовательность операций при выполнении запроса.
ESTIMATE - оценка количества строк, засечек и датапартов.
```

https://dreampuf.github.io/GraphvizOnline

##### EXPLAIN PIPELINE
```
EXPLAIN PIPELINE graph = 1
SELECT count(1) FROM t_pt_prop_v1 WHERE group = 'thing_1' AND name = 'vol';
```

```
digraph
{
   rankdir=" LR"   
   { node [shape = rect] 
     subgraph cluster_0 { 
       label =" Expression"   
       style=filled  
       color=lightgrey  
       node [style=filled,color=white]  
       { rank = same  
         n3 [label=" ExpressionTransform" ]  
       } 
     } 
     subgraph cluster_1 { 
       label =" Filter"   
       style=filled  
       color=lightgrey  
       node [style=filled,color=white]  
       { rank = same  
         n2 [label=" FilterTransform" ]  
       } 
     } 
     subgraph cluster_2 { 
       label =" Expression"   
       style=filled  
       color=lightgrey  
       node [style=filled,color=white]  
       { rank = same  
         n7 [label=" ExpressionTransform × 4" ]  
       } 
     } 
     subgraph cluster_3 { 
       label =" ReadFromMergeTree"   
       style=filled  
       color=lightgrey  
       node [style=filled,color=white]  
       { rank = same  
         n1 [label=" MergeTreeInOrder" ]  
       } 
     } 
     subgraph cluster_4 { 
       label =" Limit"   
       style=filled  
       color=lightgrey  
       node [style=filled,color=white]  
       { rank = same  
         n6 [label=" Limit" ]  
       } 
     } 
     subgraph cluster_5 { 
       label =" Aggregating"   
       style=filled  
       color=lightgrey  
       node [style=filled,color=white]  
       { rank = same  
         n4 [label=" AggregatingTransform" ]  
         n5 [label=" Resize" ]  
       } 
     } 
   } 
   n3 -> n4 [label=""]  
   n2 -> n3 [label=""]  
   n1 -> n2 [label=""]  
   n6 -> n7 [label=" × 4" ]  
   n4 -> n5 [label=""]  
   n5 -> n6 [label=" × 4" ]  
}
```

##### EXPLAIN PIPELINE
```
EXPLAIN ESTIMATE
SELECT count(1) FROM t_pt_prop_v1 WHERE group = 'thing_1' AND name = 'vol';
```

```csv
database,table,parts,rows,marks
backend_dev,t_pt_prop_v1,1,10,1
```

##### EXPLAIN PLAN
```
EXPLAIN description = 1
SELECT count(1) FROM t_pt_prop_v1 WHERE group = 'thing_1' AND name = 'vol';
```

```
explain
Expression ((Projection + Before ORDER BY))
"  Limit (preliminary LIMIT (without OFFSET))"
"    Aggregating"
"      Expression (Before GROUP BY)"
"        Filter (WHERE)"
"          ReadFromMergeTree (t_pt_prop_v1)"
```

#### join

```
SELECT [DISTINCT [ON (column1, column2, ...)]] expr_list
[FROM [db.]table | (subquery) | table_function] [FINAL]
[GLOBAL] [ANY|ALL|ASOF] [INNER|LEFT|RIGHT|FULL|CROSS] 
[OUTER|SEMI|ANTI] 
JOIN (subquery)|table (ON <expr_list>)|(USING <column_list>)
...
```

```
INNER JOIN возвращает только совпадающие строки.
LEFT OUTER JOIN возвращает несовпадающие строки из левой таблицы в дополнение к совпадающим строкам.
RIGHT OUTER JOIN возвращает несовпадающие строки из правой таблицы в дополнение к совпадающим строкам.
FULL OUTER JOIN возвращает несовпадающие строки из обеих таблиц в дополнение к совпадающим строкам.
CROSS JOIN производит декартово произведение таблиц целиком, ключи соединения не указываются. 
```

### data & pipes

#### data & pipes - resources
* https://clickhouse.com/docs/engines/database-engines
* https://clickhouse.com/docs/engines/table-engines/integrations/postgresql
* https://clickhouse.com/docs/engines/table-engines/integrations/kafka
