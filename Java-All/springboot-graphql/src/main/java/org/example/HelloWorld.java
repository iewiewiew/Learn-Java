package org.example;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

/**
 * @author weimenghua
 * @time 2023-01-30 11:44
 * @description
 * 参考资料：
 * https://graphql.cn/learn/
 * https://www.graphql-java.com/documentation/getting-started/
 * https://www.graphql-java-kickstart.com/spring-boot/embedded-editors/（未实践️）
 * https://github.com/graphql-java-kickstart/graphql-spring-boot
 * https://mp.weixin.qq.com/s/8EWJTRRWgLWkEYOrCHc9Dg
 * Chrome插件：altair graphql client，chrome-extension://flnheeellpciglgpaodhkhmapeljopja/index.html
 */
public class HelloWorld {
    public static void main(String[] args) {
        String schema = "type Query{hello: String}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{hello}");

        System.out.println(executionResult.getData().toString());
        // Prints: {hello=world}
    }
}
