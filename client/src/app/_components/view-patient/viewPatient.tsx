"use client"
import React from 'react';
import { useState, useEffect } from 'react';
import Prescribe from '../prescribe/prescribe';
import PrescribeForm from '../prescribe/prescribeForm';

const ViewPatients = (doctorId) => {
  const [patientInfo, setPatientInfo] = useState<string | null>(null);
  const [showModal, setShowModal] = useState(false);
  const [selectedPatientId, setSelectedPatientId] = useState<string | null>(null);
//   const [showPrescription, setShowButton] = useState(userRole === 'doctor');
  const [showPrescription, setShowButton] = useState(false);

  const handleClose = () => setShowModal(false);

  const handleShow = (patientId: string) => {
    setSelectedPatientId(patientId);
    setShowButton(true)
    setShowModal(true);
  }

  const handlePatientDetailClick = (patientId: string) => {
    setPatientInfo((prevPatientInfo) =>
      prevPatientInfo === patientId ? null : patientId
    );
  };

  const handleCloseButton = () => {
    setPatientInfo(null);
  };

//   useEffect(() => {
//     setShowButton(userRole === 'doctor');
//   }, [userRole]);

  return (
    <div className="flex flex-col md:flex-row">
      {/* Left Side - Buttons */}
      <div className="lg:w-3/5 p-4 bg-gray-200 flex-1 flex flex-col w-full">
      <table className="min-w-full bg-white border border-gray-300">
        <thead className='bg-gray-400 text-2xl'>
          <tr>
            <th className="py-2 px-4 border-b">Patient ID</th>
            <th className="py-2 px-4 border-b">Name</th>
            <th className="py-2 px-4 border-b hidden md:table-cell">#### (disappears on mobile)</th>
            <th className="py-2 px-4 border-b">Actions</th>
          </tr>
        </thead>
        <tbody>

                    {/* Add later */}
                    {/* {patients.map((patient,index) => ( */}
            {/* <tr key={index}> */}
            <tr>
              <td className="py-2 px-4 border-b"></td>
              <td className="py-2 px-4 border-b"></td>
              <td className="py-2 px-4 border-b hidden md:table-cell">1</td>
              <td className="py-2 px-4 border-b">
                <button onClick={() => handlePatientDetailClick('Name1')}
                className="bg-blue-500 text-white py-1 px-2 rounded-md hover:bg-blue-700 focus:outline-none focus:shadow-outline-blue">
                  View More
                </button>
              </td>
            </tr>
          {/* ))} */}
        </tbody>
      </table>
      </div>

      <div className={`w-full lg:w-2/5 ${patientInfo !== null ? 'flex' : 'hidden'} flex-col items-center justify-center bg-gray-300 relative p-4`}>
        <div className="text-4xl font-bold text-blue-500">
          Patient: {patientInfo}


        </div>
        <button
          className="bg-red-500 text-white p-2 rounded-full hover:bg-red-700 focus:outline-none focus:shadow-outline-red absolute top-4 right-4"
          onClick={handleCloseButton}
        >
          Close
        </button>
        {/* {/* {showPrescription && ( */}
                  <button className='bg-purple-300 text-white py-1 px-2 rounded-md hover:bg-blue-700 focus:outline-none focus:shadow-outline-blue' onClick={() => handleShow("name")}> Prescribe Medication </button>

                  {/* )} */}
      </div>


      {showPrescription &&
 (     <div>
        <PrescribeForm  show={showModal} handleClose={handleClose} patientId={selectedPatientId}/>
      </div>

)}

    </div>
  );
};



export default ViewPatients