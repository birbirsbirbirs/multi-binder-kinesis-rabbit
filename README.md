* java 21
* rabbit mq ui : http://localhost:15672, use this ui to publish message in rabbit message queue
* un guest
* ps guest

### aws query for localstack

##### in case docker does not come programmatically/automatically, manually starter compose.yaml and use following command
##### to create kinesis stream 
```shell
aws --endpoint-url=http://localhost:4566 \
kinesis create-stream --stream-name hero-kinesis-1 --shard-count 4
```
---

```shell
aws --endpoint-url=http://localhost:4566 \
kinesis list-streams
```
---

```shell
aws --endpoint-url=http://localhost:4566 \
dynamodb list-tables
```
---
* publish message in kinesis stream
* kinesis-hero-100 base64 a2luZXNpcy1oZXJvLTEwMA==
```shell
aws --endpoint-url=http://localhost:4566 \
kinesis put-record --stream-name hero-kinesis-1 --partition-key 123 --data "a2luZXNpcy1oZXJvLTEwMA=="
```
---
* get shard iterator
```shell
aws --endpoint-url=http://localhost:4566 \
kinesis get-shard-iterator --shard-id shardId-000000000000 --shard-iterator-type TRIM_HORIZON --stream-name \
hero-kinesis-1 --query 'ShardIterator' 
```
---
```shell
aws --endpoint-url=http://localhost:4566 \
kinesis get-records --shard-iterator \
AAAAAAAAAAGMhkrU0NS1EOFo0poucPhjxM4cpLS2tB3/xd60x6Zrjoqzm1tBarRmyNDOttFLdtzjU4tjxEC/KcZJ7C84IleRUbfQJFRJsFKeh2HQ+ugLhmkN1//ezTBovf8tE5a2a8XlqvBL6U6pJHMg1Hw13o6wXksELWpzG0QDjeuovcDdZQ+zYRaGCwE64OUCEpK3Wgs8ZV0XoflFnWuUgwR81b8O
```