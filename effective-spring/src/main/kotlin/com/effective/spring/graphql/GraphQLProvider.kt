package com.effective.spring.graphql

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component


@Component
class SolutionResolver(
    private val solutionQuery: SolutionQuery,
) : GraphQLQueryResolver {

    fun solutionById(id: String): Solution {
        return solutionQuery.getSolutionById(id)
    }

    fun solutionBySlug(id: String): Solution {
        return solutionQuery.getSolutionById(id)
    }
}