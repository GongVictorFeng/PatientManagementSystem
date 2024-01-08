import type { NextApiRequest, NextApiResponse } from 'next';

const SERVER_ADDR = 'http://localhost:9000'

async function postPatientRegister(data: Object) {
  const response = await fetch(`${SERVER_ADDR}/patient/register`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    },
    body: JSON.stringify(data)
  })
  const body = await response.json();
  console.log(body);

  return body;
}

async function postLogin(data: Object) {
  const response = await fetch(`${SERVER_ADDR}/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    },
    body: JSON.stringify(data)
  })
  const body = await response.json();
  console.log(body);

  return body;
}

async function getPatient(empId: string, patientId:any) {
  const response = await fetch(`${SERVER_ADDR}/${empId}/patient/${patientId}`, {
    method: 'GET'
  })
  const body = await response.json();
  return body;
}

async function updatePatient(empId: string, patientId: any, patientInfo: Object) {
  const response = await fetch(`${SERVER_ADDR}/${empId}/patient/update/${patientId}`, {
    method: 'PATCH',
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    },
    body: JSON.stringify(patientInfo)
  })
  const body = await response.text();
  return body;
}

export { postPatientRegister, postLogin, getPatient, updatePatient };
