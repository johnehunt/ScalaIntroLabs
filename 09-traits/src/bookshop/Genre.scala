package bookshop

/**
 * Provide a root trait for the case objects.
 */
sealed trait Genre

case object Fiction extends Genre
case object Technical extends Genre
case object History extends Genre
case object Detective extends Genre
case object Biography extends Genre
