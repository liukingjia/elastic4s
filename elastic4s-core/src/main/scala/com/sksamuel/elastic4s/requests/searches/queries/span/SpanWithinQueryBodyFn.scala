package com.sksamuel.elastic4s.requests.searches.queries.span

import com.sksamuel.elastic4s.json.{XContentBuilder, XContentFactory}
import com.sksamuel.elastic4s.requests.searches.queries.QueryBuilderFn

object SpanWithinQueryBodyFn {
  def apply(q: SpanWithinQuery): XContentBuilder = {

    val builder = XContentFactory.jsonBuilder()
    builder.startObject("span_within")

    builder.rawField("little", QueryBuilderFn(q.little))
    builder.rawField("big", QueryBuilderFn(q.big))

    q.boost.foreach(builder.field("boost", _))
    q.queryName.foreach(builder.field("_name", _))

    builder.endObject()
    builder.endObject()
  }
}
