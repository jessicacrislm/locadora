import React, { Component } from 'react'
import Main from '../template/Main'

const headerProps = {
    icon: 'renovacao',
    title: 'Renovação', 
    subtitle: 'Renovar uma locação de filme'
}

export default class RenovacaoCrud extends Component {
    render() {
        return (
            <Main {...headerProps} >
                Em construção...
            </Main>
        )
    }
}
