import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import Messages from "./pages/Messages";
import SignIn from "./pages/auth/SignIn";
import SignUp from "./pages/auth/SignUp";
import Homepage from "./pages/Homepage";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Homepage />} />
        <Route path="/sign-in" element={<SignIn />} />
        <Route path="/sign-up" element={<SignUp />} />
        <Route path="/chat/:id" element={<Messages />} />
      </Routes>
    </Router>
  );
}

export default App;
