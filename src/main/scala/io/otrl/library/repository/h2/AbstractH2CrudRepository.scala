package io.otrl.library.repository.h2

import com.hazelcast.core.Hazelcast
import io.otrl.library.domain.Identifiable
import io.otrl.library.repository._
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.mutable.Map
import scala.language.postfixOps
import scala.util.{Success, Try}

abstract class AbstractH2CrudRepository[T <: Identifiable](implicit manifest: Manifest[T])
  extends AbstractPartialCrudRepository[T] with PartialUpdates[T] with Queryable[T] {

  protected val logger: Logger = LoggerFactory getLogger getClass

  private val map: Map[String, T] = Map.empty[String, T]

  override def create(resource: T): Try[T] = {
    logger info s"creating $resource"
    resource.id = "123"
    logger info s"created id ${resource.id}"
    map += resource.id -> resource
    Success(resource)
  }

  override def read(resourceId: String): Try[Option[T]] = {
    logger info s"reading $resourceId"
    Success(map.get(resourceId))
  }

    override def update(resourceId: String, updatePayload: String): Try[Option[AnyRef]] = {
      logger info s"updating $resourceId $updatePayload"
      throw new UnsupportedOperationException("not yet implemented")
    }

//  override def update(resource: T): Try[Option[T]] = {
//    logger info s"updating $resource"
//    throw new UnsupportedOperationException("not yet implemented")
//  }

  override def delete(resourceId: String): Try[Option[Unit]] = {
    logger info s"deleting $resourceId"
    if (map contains resourceId) Try(Option(map -= resourceId))
    else Success(None)
  }

  override def query(queryString: String): Try[Paginated[T]] = {
    logger info s"querying $queryString"
    throw new UnsupportedOperationException("not yet implemented")
  }

}
