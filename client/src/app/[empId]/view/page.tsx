"use client"
import React from 'react'
import AdmitPatient from '@/app/_components/forms/admitPatient';
import PatientProfile from '@/app/_components/profile/patientProfile';


const page = ({searchParams}) => {
    const id= searchParams.patientId
    console.log(id);
  return (
    <PatientProfile patientId={id}/>
  )
}

export default page