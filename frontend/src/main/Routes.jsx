import React from 'react'
import { Switch, Route, Redirect } from 'react-router'

import Home from '../components/home/Home'
import UsuarioCrud from '../components/usuario/UsuarioCrud'
import ConsultaUsuarioCrud from '../components/usuario/ConsultaUsuarioCrud'
import FilmeCrud from '../components/filme/FilmeCrud'
import ConsultaFilmeCrud from '../components/filme/ConsultaFilmeCrud'
import LocacaoCrud from '../components/locacao/LocacaoCrud'
import RenovacaoCrud from '../components/locacao/RenovacaoCrud'
import DevolucaoCrud from '../components/locacao/DevolucaoCrud'
import HistoricoCrud from '../components/locacao/HistoricoCrud'

export default props =>
    <Switch>
        <Route exact path='/' component={Home} />
        <Route exact path='/usuario' component={UsuarioCrud} />
        <Route exact path='/consulta-usuario' component={ConsultaUsuarioCrud} />
        <Route exact path='/filme' component={FilmeCrud} />
        <Route exact path='/consulta-filme' component={ConsultaFilmeCrud} />
        <Route exact path='/locacao' component={LocacaoCrud} />
        <Route exact path='/renovacao' component={RenovacaoCrud} />
        <Route exact path='/devolucao' component={DevolucaoCrud} />
        <Route exact path='/historico' component={HistoricoCrud} />
        <Redirect from='*' to='/' />
    </Switch>