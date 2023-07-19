'use strict';
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');


class App extends React.Component {


    constructor(props) {
        super(props);
        this.state = {vehicleEntities: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/vehicles'}).done(response => {
            this.setState({vehicleEntities: response.entity});
        });
    }


    render() {
        return (
            <VehicleList vehicles={this.state.vehicleEntities}/>
        )
    }
}

class VehicleList extends React.Component{
    render() {
        const vehicles = this.props.vehicles.map(vehicle =>
            <Vehicle key={vehicle} vehicle={vehicle}/>
        );
        return (
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
