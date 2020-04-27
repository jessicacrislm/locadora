import React, { Component } from 'react'
import Main from '../template/Main'

const headerProps = {
    icon: 'locacao',
    title: 'Locação', 
    subtitle: 'Controle de locação: incluir, renovar, fechar e exibir histórico'
}

export default class LocacaoCrud extends Component {
    render() {
        return (
            <Main {...headerProps} >
                Em construção...
            </Main>
        )
    }
}
