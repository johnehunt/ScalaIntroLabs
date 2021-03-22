package com.jjh.bookshop.domain

/**
 * Exception class for use with the Bookshop
 *
 * @param _msg Message to be displayed with the exception.
 */
class BookshopException(_msg: String = "Bookshop Error") extends RuntimeException(_msg)
