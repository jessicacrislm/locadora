import React, { Component } from 'react'
import Main from '../template/Main'

const headerProps = {
    icon: 'filme',
    title: 'Filme', 
    subtitle: 'Controle de filmes: incluir, alterar, apagar e listar'
}

export default class FilmeCrud extends Component {
    render() {
        return (
            <Main {...headerProps} >
                Em construção...
            </Main>
        )
    }
}
