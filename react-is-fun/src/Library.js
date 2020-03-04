import React, { Component } from "react"
import PropTypes from 'prop-types'
import {Book} from './Book'
import Hiring from './Hiring'
import {NotHiring} from './NotHiring'

class Library extends Component {
    componentDidMount() {
      this.setState({ loading: true })
      fetch('https://hplussport.com/api/products/order/price/sort/asc/qty/1')
        .then(data => data.json())
        .then(data => this.setState({ data, loading: false }))
      console.log('Library did mount')
      console.log(this.state.data)
    }
  
    componentDidUpdate() {
      console.log('Library did update')
    }
  
    static defaultProps ={
      books: [
        {"title": "Jumanji", "author": 'No', "pages": 360 }
      ]
    }
  
    state = {
      open: true,
      freeBookmark: true,
      hiring: false,
      data: [],
      loading: false
    }
  
    toggleOpenClosed = this.toggleOpenClosed.bind(this)
  
    toggleOpenClosed() {
      this.setState(prevState => ({
        open: !prevState.open
      }))
    }
  
    render() {
      const { books } = this.props
      return (
        <div >
          <h1>The library is {this.state.open ? 'open' : 'closed'}.</h1>
          <button onClick={this.toggleOpenClosed} >Change</button>
          {this.state.hiring ? <Hiring/> : <NotHiring />}
          {this.state.loading ?
            'loading...' :
            <div>
              {this.state.data.map( product => {
                return (
                  <div key={product.id}>
                    <h3>Library product of the week</h3>
                    <h4>{product.name}</h4>
                    <img alt={product.name} src={product.image} height={100}></img>
                  </div>
                )
              })}
            </div>
          }
          {books.map(
            (book, i) =>
              <Book
                key={i}
                title={book.title}
                author={book.author}
                pages={book.pages}
                freeBookmark={this.state.freeBookmark}
              />
          )
          }
        </div>
      )
    }
  }
  
  Library.propTypes= {
    books: PropTypes.array
  }
  


  export default Library