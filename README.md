# Multimatch cross_fields_prefix plugin

This is a plugin for ElasticSearch that allows combining `cross_fields` and `bool_prefix` as a new type in a `multi_match` query.

### ElasticSearch example

Like `cross_fields`, `cross_fields_prefix` analyzes the query
string into individual terms, then looks for each term as a prefix
in any of the fields.
```json
{
  "query": {
    "multi_match_plugin" : {
      "query":      "Will Smith",
      "type":       "cross_fields_prefix",
      "fields":     [ "first_name", "last_name" ],
      "operator":   "and"
    }
  }
} 
```

Is executed as:

```json
+(first_name:will* last_name:will*)
+(first_name:smith* last_name:smith*)
```

`cross_fields_prefix` works similar as `cross_fields` as described [here](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-multi-match-query.html#type-cross-fields), 
e.g. term frequencies are blended, and the `fuzziness` parameter **cannot** be used.

### Adding the plugin

Generate a zip containing the plugin:
`mvn clean install`

Install the plugin: `./bin/elasticsearch-plugin install file://PATH_TO_ZIP`

### Removing the plugin

`./bin/elasticsearch-plugin remove crossfields-prefix`

### Debugging the plugin

Start ElasticSearch
with: `ES_JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 ./bin/elasticsearch`

Create a new remote debugging configuration that attaches to a remote JVM.
