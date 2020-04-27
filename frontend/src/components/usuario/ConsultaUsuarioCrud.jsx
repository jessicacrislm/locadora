import React, { Component } from 'react'
import Main from '../template/Main'

const headerProps = {
    icon: 'consulta-usuario',
    title: 'Consulta de usuário', 
    subtitle: 'Consultar um usuário para edição ou remoção'
}

export default class ConsultaUsuarioCrud extends Component {
    render() {
        return (
            <Main {...headerProps} >
                Em construção...
            </Main>
        )
    }
}
