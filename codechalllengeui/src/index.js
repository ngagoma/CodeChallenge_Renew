import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';
import './index.css';

class InputLimit extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      listPrimes: [],
      inputVal : 0
    };
  }

  checkValue(value){
    if (Number.isInteger(Number(value))){
      return true;
    }    
    else{
      alert("this is not an Integer!");
      return false;
    }
  }

  displayAllPrimes() {
  
   if(this.checkValue(this.state.inputVal)) {
    fetch("http://localhost:8082/api/v1/primes/" + this.state.inputVal, {
      "method": "GET",
      "headers": {
        "content-type": "application/json",
        "accept": "application/json"
      }
    })
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            listPrimes: result
          });
        },
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      );
    }
  }

 

  render() {
    const status = 'Enter Max Number and hit display all Prime Numbers';
    const buttonLabel = "Display All Prime Numbers";

    return (
      <div className="container">
        <div className="status">{status}</div>
        <input 
          placeholder="Enter a Number"
          type="number"
          value={this.state.inputVal}
          onChange={(e) => this.setState({inputVal: e.target.value})}
          />
        <button className="btn-success" onClick={() => this.displayAllPrimes()}>{buttonLabel}</button>

          <div className="wrapper" isLoaded>
              <div className="box"> {this.state.listPrimes.join(" ").trim()} </div>
          </div>
          
      </div>
     
    );
  }
}

class CodeChallenge extends React.Component {
  render() {
    return (
      <div className="game">
        <div className="game-board">
          <InputLimit />
        </div>
      </div>
    );
  }
}

// ========================================


ReactDOM.render(<CodeChallenge />, document.getElementById('root'));