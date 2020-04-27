import React, { Component } from 'react'
import Main from '../template/Main'

const headerProps = {
    icon: 'historico',
    title: 'Histórico de locações', 
    subtitle: 'Exibir o histórico de locações por usuário ou filme'
}

export default class HistoricoCrud extends Component {
    render() {
        return (
            <Main {...headerProps} >
                Em construção...
            </Main>
        )
    }
}
