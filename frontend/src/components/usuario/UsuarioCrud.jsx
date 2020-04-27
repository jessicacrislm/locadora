import React, { Component } from 'react'
import axios from 'axios'
import Main from '../template/Main'
import { headerPost } from '../service/Headers'

const headerProps = {
    icon: 'usuario',
    title: 'Usuário',
    subtitle: 'Controle de usuários: incluir, alterar, apagar e listar'
}

const baseUrl = 'http://localhost:8080/api/usuario'
const initialState = {
    usuario: { nome: '', sexo: '', dataNascimento: '', cpf: '' },
    list: []
}

export default class UsuarioCrud extends Component {

    constructor(props) {
        super(props);
        this.state = { nome: '', sexo: '', dataNascimento: '', cpf: '' }
    }
    state = { ...initialState }

    clear() {
        this.setState({ usuario: initialState.usuario })
    }

    save() {
        console.log(this.state.nome, this.state.sexo, this.state.dataNascimento, this.state.cpf)
        
        let body = { 
            id: null,
            nome: this.state.nome, 
            sexo: this.state.sexo, 
            dataNascimento: this.state.dataNascimento, 
            cpf: this.state.cpf
        }

        fetch(`${baseUrl}`, headerPost(body)).then(resp => {
            console.log(resp)
        })
    }


    getUpdatedList(usuario) {
        const list = this.state.list.filter(u => u.id !== usuario.id)
        list.unshift(usuario)
        return list
    }

    updateField(event) {
        //const usuario = { ...this.state.usuario }
        //usuario[event.target.nome] = event.target.value
        this.setState({ usuario: event.target.value })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label id="lblNome">Nome</label>
                            <input id="txtNome" type="text"
                                className="form-control"
                                name="nome"
                                value={this.state.nome}
                                onChange={(e) => this.setState({ nome: e.target.value })}
                                placeholder="Digite o nome..." />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label id="lblSexo">Sexo</label>
                            <select class="custom-select mr-sm-2" id="slcSexo" onChange={(e) => this.setState({ sexo: e.target.value })} name="sexo">
                                <option selected>Informe o sexo...</option>
                                <option value={'FEMININO'}>Feminino</option>
                                <option value={'MASCULINO'}>Masculino</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label id="lblDataNascimento">Data de nascimento</label>
                            <input id="txtDataNascimento" type="text"
                                className="form-control"
                                name="dataNascimento"
                                value={this.state.dataNascimento}
                                onChange={(e) => this.setState({ dataNascimento: e.target.value })}
                                placeholder="Ex.: 09/08/1994..." />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label id="lblCpf">CPF</label>
                            <input id="txtCpf" type="text"
                                className="form-control"
                                name="cpf"
                                value={this.state.cpf}
                                onChange={(e) => this.setState({ cpf: e.target.value })}
                                placeholder="Digite o CPF" />
                        </div>
                    </div>
                </div>

                <hr />
                <div className="row">
                    <div className="col-12 d-flex justify-content-end">
                        <button className="btn btn-primary"
                            onClick={e => this.save(e)}>
                            Salvar
                        </button>

                        <button className="btn btn-secondary ml-2"
                            onClick={e => this.clear(e)}>
                            Cancelar
                        </button>
                    </div>
                </div>

            </div>
        )
    }

    componentDidMount() {
        console.log("TESTE TESTE")
    }

    render() {
        return (
            <Main {...headerProps} >
                {this.renderForm()}
            </Main>
        )
    }
}
