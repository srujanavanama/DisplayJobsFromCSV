import React from 'react';
import { Link, withRouter } from 'react-router-dom';

const HeaderComponent = () => {
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <ul className="navbar-nav">
                        <li><Link className="nav-link" to="/">Home</Link></li>
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        <li><Link className="nav-link" to="/jobs">Jobs List</Link></li>
                    </ul>
                </nav>
            </header>
        );
}

export default withRouter(HeaderComponent)