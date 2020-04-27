import './Nav.css'
import { Link } from 'react-router-dom'
import React, { Component } from 'react'

export default props =>
    <aside className="menu-area">
        <nav className="menu">
            <Link to="/">
                <i className="fa fa-home">
                    <label className="menu-label">Início</label>    
                </i> 
            </Link>

            <Link to="/usuario">
                <i className="fa fa-users">
                    <label className="menu-label">Cadastro de usuário</label>    
                </i> 
            </Link>

            <Link to="/consulta-usuario">
                <i className="fa fa-search">
                    <label className="menu-label">Consulta de usuário</label>    
                </i> 
            </Link>

            <Link to="/filme">
                <i className="fa fa-users">
                    <label className="menu-label">Cadastro de filme</label>    
                </i> 
            </Link>

            <Link to="/consulta-filme">
                <i className="fa fa-search">
                    <label className="menu-label">Consulta de filme</label>    
                </i> 
            </Link>

            <Link to="/locacao">
                <i className="fa fa-exchange">
                    <label className="menu-label">Nova locacão</label>    
                </i> 
            </Link>

            <Link to="/renovacao">
                <i className="fa fa-refresh">
                    <label className="menu-label">Renovação</label>    
                </i> 
            </Link>

            <Link to="/devolucao">
                <i className="fa fa-reply">
                    <label className="menu-label">Devolução</label>    
                </i> 
            </Link>

            <Link to="/historico">
                <i className="fa fa-history">
                    <label className="menu-label">Histórico de locação</label>    
                </i> 
            </Link>

        </nav>
    </aside>