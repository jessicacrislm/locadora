import React, { Component } from 'react'
import Main from '../template/Main'

const headerProps = {
    icon: 'consulta-filme',
    title: 'Consultar um filme', 
    subtitle: 'Consultar um filme para edição ou remoção'
}

export default class ConsultaFilmeCrud extends Component {
    render() {
        return (
            <Main {...headerProps} >
                Em construção...
            </Main>
        )
    }
}
