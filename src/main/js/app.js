'use strict';
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');


class App extends React.Component {


    constructor(props) {
        super(props);
        this.state = {vehicleEntities: []};
        this.searchVehicles = this.searchVehicles.bind(this)
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/vehicles'}).done(response => {
            this.setState({vehicleEntities: response.entity});
        });
    }

    searchVehicles(brand, model, category, number, year){
        client({method: 'GET', path:'/api/vehicles/search?brand=' + brand
                +'&model=' + model
                + '&category=' + category
                +'&number=' + number
                + '&year=' + year
        }).done(response =>{
            this.setState({vehicleEntities: response.entity});
                });
    }

    render() {
        return (
            <div>
                <VehicleList vehicles={this.state.vehicleEntities}
                searchVehicles={this.searchVehicles}/>
            </div>
        )
    }
}
class VehicleList extends React.Component{
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e){
        e.preventDefault();
        const brand = ReactDOM.findDOMNode(this.refs.brand).value;
        const model = ReactDOM.findDOMNode(this.refs.model).value;
        const category = ReactDOM.findDOMNode(this.refs.category).value;
        const number = ReactDOM.findDOMNode(this.refs.number).value;
        const year = ReactDOM.findDOMNode(this.refs.year).value;
        this.props.searchVehicles(brand,model,category,number,year);

    }
    render() {
        const vehicles = this.props.vehicles.map(vehicle =>
            <Vehicle key={vehicle} vehicle={vehicle}/>
        );
        return (
            <div>
            <table>
                <tbody>
                <tr>
                    <th>Марка</th>
                    <th>Модель</th>
                    <th>Категория ТС</th>
                    <th>Гос. номер</th>
                    <th>Тип ТС</th>
                    <th>Год выпуска</th>
                    <th>Начилие прицепа</th>
                </tr>
                {vehicles}
                </tbody>
            </table>
            <div>
                <text>Найти транспортное средство: </text>
                <form
                    id="SearchBar"
                    className="space-x-0.5 flex"
                    onSubmit={this.handleSubmit}
                >
                    <input type="string" className="vehicle-filter" ref="brand" placeholder="Марка" />
                    <input type="string" className="vehicle-filter" ref="model" placeholder="Модель" />
                    <input type="string" className="vehicle-filter" ref="category" placeholder="Категория"/>
                    <input type="string" className="vehicle-filter" ref="number" placeholder="Гос. номер"/>
                    <input type="string" className="vehicle-filter" ref="year" placeholder="Год выпуска"/>
                    <button className="button-search">
                        Найти
                    </button>
                </form>
            </div>
            </div>
        )
    }
}

class Vehicle extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.vehicle.brand}</td>
                <td>{this.props.vehicle.model}</td>
                <td>{this.props.vehicle.category}</td>
                <td>{this.props.vehicle.number}</td>
                <td>{this.props.vehicle.type}</td>
                <td>{this.props.vehicle.manufactured}</td>
                <td>{this.props.vehicle.trailer}</td>
            </tr>
        )
    }
}
ReactDOM.render(
    <App />,
    document.getElementById('react')
)
