
import { Link, useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

export default function SignIn() {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [cnic, setCnic] = useState("");
    const [address, setAddress] = useState("");
    const [contact, setContact] = useState("");
    const [dob, setDob] = useState("");
    const [card_pid, setCard_pid] = useState("");
    const [card_cvv, setCard_cvv] = useState("");
    const [card_expiry, setCard_expiry] = useState("");

    const [todayDate, setTodayDate] = useState("");

    const today = () => {
        const date = new Date();
        const day =
            String(date.getDate()).length === 1
                ? "0" + String(date.getDate())
                : date.getDate();

        const month =
            String(date.getMonth()).length === 1
                ? "0" + String(date.getMonth())
                : date.getMonth();
        const year = date.getFullYear();
        setTodayDate(year + "-" + month + "-" + day);
        console.log(year + "-" + month + "-" + day);
    };

    useEffect(() => {
        today();
    }, []);
    const navigate = useNavigate();

    const signUp = async () => {
        const newUser = {
            name: name,
            email: email,
            password: password,
            cnic: cnic,
            address: address,
            contact: contact,
            dob: dob,
            card_pid: card_pid,
            card_cvv: card_cvv,
            card_expiry: card_expiry,
        };

        if (password === confirmPassword)
            await axios
                .post("http://localhost:8080/api/v1/user/", newUser)
                .then(function (response) {
                    console.log(response)
                    if (response.data.statusCode === 200) {
                        localStorage.setItem("jwt", response.data.jwt);
                        localStorage.setItem("csrf", response.data.csrf);

                        console.log("csrf ="+ response.data.csrf)
                        console.log("jwt ="+ response.data.jwt)

                        navigate(`/welcome/${response.data.id}`);
                    } else if (response.data.statusCode === 400)
                        alert("User with this email aready exists ");
                    else alert("Error Creating User ");
                })
                .catch(function (error) {
                    console.log(error);
                });
        else alert("Passwords do not match");
    };
    return (
        <div className=" flex justify-center mt-8">
            <div className="w-96 bg-slate-50 rounded-xl min-h-full py-12 px-4 sm:px-4 lg:px-4">
                <div className="max-w-md w-full space-y-8">
                    <div>
                        <img
                            className="mx-auto h-12 w-auto"
                            src="https://tailwindui.com/img/logos/workflow-mark.svg?color=indigo&shade=600"
                            alt="Workflow"
                        />
                        <h2 className="mt-6 text-center text-3xl tracking-tight font-bold text-gray-900">
                            Create an Account
                        </h2>
                    </div>
                    <form
                        className="mt-8 space-y-6"
                        onSubmit={(event) => {
                            event.preventDefault();
                        }}
                    >
                        <div className="rounded-md shadow-sm -space-y-px">
                            <div>
                                <h3 className=" mb-2 ml-2 font-medium text-indigo-600 hover:text-indigo-500">
                                    Account Informationn
                                </h3>
                                <input
                                    id="name"
                                    name="name"
                                    type="text"
                                    autoComplete="name"
                                    required
                                    value={name}
                                    onChange={(e) => {
                                        setName(e.target.value);
                                    }}
                                    className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="Name"
                                />
                                <input
                                    id="email-address"
                                    name="email"
                                    type="email"
                                    autoComplete="email"
                                    required
                                    className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="Email address"
                                    value={email}
                                    onChange={(e) => {
                                        setEmail(e.target.value);
                                    }}
                                />
                                <input
                                    id="password"
                                    name="password"
                                    type="password"
                                    autoComplete="paassword"
                                    required
                                    className="my-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="Pasword"
                                    value={password}
                                    onChange={(e) => {
                                        setPassword(e.target.value);
                                    }}
                                />
                                <input
                                    id="confirm-password"
                                    name="confirm-password"
                                    type="password"
                                    autoComplete="confirm-password"
                                    required
                                    className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="Confirm Password"
                                    value={confirmPassword}
                                    onChange={(e) => {
                                        setConfirmPassword(e.target.value);
                                    }}
                                />
                                {password != confirmPassword && confirmPassword != "" ? (
                                    <p className="text-red-600 text-small">
                                        Passwords do not match
                                    </p>
                                ) : (
                                    <></>
                                )}
                            </div>
                            {/* CNIC INFO AND ETC */}
                            <div>
                                <h3 className=" mb-2 ml-2 font-medium text-indigo-600 hover:text-indigo-500">
                                    Personal Informationn
                                </h3>
                                <input
                                    id="cnic"
                                    name="cnic"
                                    type="text"
                                    autoComplete="cnic"
                                    required
                                    minLength={13}
                                    maxLength={13}
                                    className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="CNIC"
                                    value={cnic}
                                    onChange={(e) => {
                                        setCnic(e.target.value.replace(/\D/g, ''));
                                    }}
                                />
                                <input
                                    id="address"
                                    name="address"
                                    type="text"
                                    autoComplete="address"
                                    required
                                    className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="Address"
                                    value={address}
                                    onChange={(e) => {
                                        setAddress(e.target.value);
                                    }}
                                />
                                <input
                                    id="contact"
                                    name="contact"
                                    type="text"
                                    minLength={11}
                                    maxLength={11}
                                    autoComplete="contact"
                                    required
                                    className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="Contact"
                                    value={contact}
                                    onChange={(e) => {
                                        setContact(e.target.value.replace(/\D/g, ''));
                                    }}
                                />
                                <input
                                    id="dob"
                                    name="dob"
                                    type="date"
                                    autoComplete="dob"
                                    required
                                    className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="DOB"
                                    value={dob}
                                    max={todayDate}
                                    onChange={(e) => {
                                        setDob(e.target.value);
                                    }}
                                />
                            </div>
                            <div>
                                <h3 className=" mb-2 ml-2 font-medium text-indigo-600 hover:text-indigo-500">
                                    Payment Informationn
                                </h3>
                                <input
                                    id="card-no"
                                    name="card-no"
                                    autoComplete="card-no"
                                    required
                                    type="text"
                                    minLength={16}
                                    maxLength={16}
                                    className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                    placeholder="Card Number"
                                    value={card_pid}
                                    onChange={(e) => {
                                        setCard_pid(e.target.value.replace(/\D/g, ''));
                                    }}
                                />
                                <div className="flex gap-2">
                                    <input
                                        id="cvv"
                                        name="cvv"
                                        type="text"
                                        // pattern="[0-9]"
                                        autoComplete="cvv"
                                        required
                                        minLength={3}
                                        maxLength={3}
                                        className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                        placeholder="CVV"
                                        value={card_cvv}
                                        onChange={(e) => {
                                            setCard_cvv(e.target.value.replace(/\D/g, ''));
                                        }}
                                    />
                                    <input
                                        id="card-expiry"
                                        name="card-expiry"
                                        type="date"
                                        autoComplete="card-expiry"
                                        required
                                        className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                                        placeholder="Expiry"
                                        value={card_expiry}
                                        min={todayDate}
                                        onChange={(e) => {
                                            setCard_expiry(e.target.value);
                                        }}
                                    />
                                </div>
                            </div>
                        </div>
                        <div className="flex items-center justify-between">
                            <div className="flex items-center">
                                <input
                                    id="remember-me"
                                    name="remember-me"
                                    type="checkbox"
                                    className="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
                                />
                                <label
                                    htmlFor="remember-me"
                                    className="ml-2 block text-sm text-gray-900"
                                >
                                    Remember me
                                </label>
                            </div>

                            <div className="text-sm">
                                <Link
                                    to="/sign-in"
                                    className="font-medium text-indigo-600 hover:text-indigo-500"
                                >
                                    Already have an account ?
                                </Link>
                            </div>
                        </div>
                        <div>
                            <button
                                type="submit"
                                onClick={signUp}
                                className="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                            >
                <span className="absolute left-0 inset-y-0 flex items-center pl-3">
                </span>
                                Sign Up
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}