import React, { Suspense, lazy } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import WelcomeComponent from "./WelcomeComponent";
import JobComponent from "./JobComponent";
const ListJobComponent = lazy(() => import("./ListJobComponent"));

const DisplayJobApp = () => {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <Suspense fallback={<div>Loading...</div>}>
          <Switch>
            <Route path="/" exact component={WelcomeComponent} />
            <Route path="/jobs" exact component={ListJobComponent} />
            <Route path="/jobs/:jobId" component={JobComponent} />
          </Switch>
        </Suspense>
      </Router>
    </div>
  );
};

export default DisplayJobApp;
