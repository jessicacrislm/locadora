import React, { Component } from 'react'
import Main from '../template/Main'

const headerProps = {
    icon: 'devolucao',
    title: 'Devolução', 
    subtitle: 'Devolver uma locação de filme'
}

export default class DevolucaoCrud extends Component {
    render() {
        return (
            <Main {...headerProps} >
                Em construção...
            </Main>
        )
    }
}
