import React, { Component } from "react"
import ReactDom, { render } from "react-dom"
import Library from './Library'

class FavoriteColorForm extends Component {
  state = { value: '' }
  newColor = e =>
    this.setState({ value: e.target.value })
  submit = e => {
    console.log('New color: ${this.state.value}')
  }
  render() {
    return (
      <form onSubmit={this.submit}>
        <label>Favorite color
          <input
            type='color'
            onChange={this.newColor}>
          </input>
        </label>
        <button>Submit</button>
      </form>
    )
  }
}

ReactDom.render(
  <FavoriteColorForm />,
  document.getElementById('root')
)

let bookList = {
  'books': [
  { "title": "The sun also rises", "author": 'Ernest Hemingway', "pages": 260 },
  { "title": "The sun also rises 2", "author": 'Ernest Hemingway', "pages": 360 },
  { "title": "The sun also rises 3", "author": 'Ernest Hemingway', "pages": 460 }
]}

render(
  <Library books={bookList.books} />,
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

