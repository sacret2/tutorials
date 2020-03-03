import React, { Component } from "react"
import ReactDom, { render } from "react-dom"

let bookList = [
  { "title": "The sun also rises", "author": 'Ernest Hemingway', "pages": 260 },
  { "title": "The sun also rises 2", "author": 'Ernest Hemingway', "pages": 360 },
  { "title": "The sun also rises 3", "author": 'Ernest Hemingway', "pages": 460 }
]

const Hiring = () =>
  <div>
    <p>The Library is hiring. Go to www.library.com/jobs for more.</p>
  </div>

const NotHiring = () =>
  <div>
    <p>The Library is not hiring. Check back later for more info</p>
  </div>

const Book = ({ title, author, pages, freeBookmark }) => {
  return (
    <section>
      <h2>{title}</h2>
      <p>by: {author}</p>
      <p>pages: {pages} pages</p>
      <p>Free bookmark today: {freeBookmark ? 'yes' : 'no'}</p>
    </section>
  )
}

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
        {this.state.hiring ? Hiring() : <NotHiring />}
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

render(
  <Library sth='ff' books={bookList} />,
  document.getElementById("root")
)


// const calcPercent = decimal => {
//   return decimal * 100 + '%'
// }
// const getPercent = (total, goal) => {
//   return calcPercent(total/goal)
// }

// const SkiDayCounter = ({total, powder, backcountry, goal}) => {
//   return(
//     <section>
//         <div>
//           Ski days = {total}
//         </div>
//         <div>
//           powder days = {powder}
//         </div>
//         <div>
//           backcountry = {backcountry}
//         </div>
//         <div>
//           goal = {goal}
//         </div>
//         <div>
//           goal realized in = {getPercent(total, goal)}
//         </div>
//       </section>
//   )
// }

// var skiData = {
//   total: 50,
//   powder: 20,
//   sth: 1,
//   backcountry: 10,
//   goal: 100
// }

// render(
//   <SkiDayCounter total={skiData.total} powder={skiData.powder}
//     backcountry={skiData.backcountry} goal={skiData.goal} />,
//   document.getElementById("root")
// )






// class Message extends React.Component {
//   render() {
//     console.log(this.props)
//     return (
//       <div>
//         <h1  style={this.props.styleC + {font-size: {this.props.fontt}}}>
//           Helo everyone {this.props.sth}
//         </h1>
//       </div>
//     )
//   }
// }

// ReactDom.render(<Message fontt={4} styleC={ {color:'orange'} } sth='sometext'/>, document.getElementById("root"))

// var style = {
//   backgroundColor: 'orange',
//   color: 'white',
//   fontFamily: 'Arial'
// }

// const title = React.createElement(
//   'ul',
//   {id: 'title', className: 'header', style: style},
//   React.createElement(
//     'li', 
//     {},
//     'item on our list'
//   )
// )
// ReactDom.render(
//   title, 
//   document.getElementById('root')
// )

// ReactDom.render(
//   <div style={{color: 'red'}} >
//     <h1>Hello world</h1>
//     <p>We are glad you're here</p>
//     </div>
//   , 
//   document.getElementById('root')
// )

