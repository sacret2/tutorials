import React, { Component } from "react"
import PropTypes from 'prop-types'

export const Book = ({ title, author, pages, freeBookmark }) => {
    return (
      <section>
        <h2>{title}</h2>
        <p>by: {author}</p>
        <p>pages: {pages} pages</p>
        <p>Free bookmark today: {freeBookmark ? 'yes' : 'no'}</p>
      </section>
    )
  }

  Book.PropTypes = {
    title: PropTypes.string,
    author: PropTypes.string,
    pages: PropTypes.number,
    freeBookmark: PropTypes.bool
  }
  
