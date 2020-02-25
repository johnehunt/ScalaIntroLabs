package bookshop

/**
 * Exception class for use with the Bookshop
 * @param _msg Messaeg ti be displayed with the exception.
 */
class BookshopException(_msg: String = "Bookshop Error") extends RuntimeException(_msg)
